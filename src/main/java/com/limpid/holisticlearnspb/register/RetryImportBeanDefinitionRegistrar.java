package com.limpid.holisticlearnspb.register;

import com.limpid.holisticlearnspb.annotation.EnableRetry;
import com.limpid.holisticlearnspb.annotation.Retry;
import com.limpid.holisticlearnspb.aspect.RetryAspect;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @auther cuiqiongyu
 * @create 2019/9/3 13:25
 */
public class RetryImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        if (annotationMetadata.isAnnotated(EnableRetry.class.getName())) {
            BeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(RetryAspect.class).getBeanDefinition();
            beanDefinitionRegistry.registerBeanDefinition(RetryAspect.class.getName(), beanDefinition);
        }
    }

}
