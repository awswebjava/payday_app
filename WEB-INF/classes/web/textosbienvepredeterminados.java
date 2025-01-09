package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class textosbienvepredeterminados extends GXProcedure
{
   public textosbienvepredeterminados( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( textosbienvepredeterminados.class ), "" );
   }

   public textosbienvepredeterminados( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.Sdtini_bienvenida_ini_bienvenidaItem> executeUdp( )
   {
      textosbienvepredeterminados.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<web.Sdtini_bienvenida_ini_bienvenidaItem>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<web.Sdtini_bienvenida_ini_bienvenidaItem>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<web.Sdtini_bienvenida_ini_bienvenidaItem>[] aP0 )
   {
      textosbienvepredeterminados.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Ajuste de sueldos por inflación", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de ajuste de sueldos por inflación!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí podrás actualizar los sueldos de los empleados fuera de convenio por un porcentaje. De forma masiva, o seleccionando los legajos específicos.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Egresos / Permanencias", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Antiguedad / Permanencias!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí podrás gestionar y visualizar los periodos de permanencia que pueden o no afectar a la antiguedad de los empleados.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Cuenta corriente de vacaciones", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de cuenta corriente de vacaciones!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí podrás gestionar y visualizar el estado de los días de vacaciones disponibles de los empleados. Esta herramienta te permitirá controlar fácilmente los días acumulados, gozados y pendientes, asegurando que siempre haya una visión clara de la disponibilidad de las vacaciones.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Códigos SIRADIG", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la sección de códigos SIRADIG!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí puedes visualizar la lista de códigos designados por AFIP para las deducciones ingresadas mediante SIRADIG y su relación con los conceptos del sistema.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Condiciones de exención", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la sección de Condiciones de exención de IIGG!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí puedes visualizar la parametrización que indica la lógica para aplicar o descartar un tratamiento de exención según la normativa vigente. Se recibirán actualizaciones del sistema en caso de ser necesario para estar al día con las normativas vigentes", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Tratamientos de exención IIGG", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la sección de Tratamientos de exención IIGG!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí puedes gestionar los distintos tratamientos de exención de tributo a impuesto a las ganancias a asignar a cada concepto. Según la parametrización de un tratamiento, puede gravar totalmente, o estar exento total o parcialmente según distintas parametrizaciones posibles y con posibilidad de configurar el gravado del impuesto en cuotas cuando corresponda. Estos datos además de poder ser personalizados según la necesidad, recibirán actualizaciones del sistema para estar al día con las normativas generales vigentes", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Siniestrados", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la sección de siniestrados de AFIP!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí puedes visualizar una lista de accidentes de trabajo definidas por AFIP con sus respectivos códigos. Este dato se utiliza para enviar en el libro de sueldos digital el código correcto según el tipo de accidente que sufrió el empleado", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Condiciones", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la sección de condiciones de AFIP!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí puedes visualizar una lista de condiciones de trabajo definidas por AFIP con sus respectivos códigos. Este dato se utiliza para enviar en el libro de sueldos digital el código correcto según la condición del empleado", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Modalidades de contratación", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la sección de modalidades de contratación de AFIP!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí puedes visualizar una lista de modalidades de contratación definidas por AFIP con sus respectivos códigos. Este dato se utiliza para enviar en el libro de sueldos digital el código correcto según la modalidad de contratación del empleado", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Zonas", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la sección de zonas de AFIP!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí puedes visualizar una lista de zonas definidas por AFIP con sus respectivos códigos. Este dato se utiliza para enviar en el libro de sueldos digital el código correcto según la zona geográfica del empleado, y determinar posibles beneficios fiscales según las regulaciones", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Tipos de empleador", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la sección de tipos de empleador de AFIP!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí puedes visualizar una lista de tipos de empleador definidas por AFIP con sus respectivos códigos. Este dato se utiliza para enviar en el libro de sueldos digital el código correcto según el tipo de empleador, y para calcular los porcentajes de contribuciones patronales", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Actividades", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la sección de actividades de AFIP!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí puedes visualizar una lista de actividades definidas por AFIP con sus respectivos códigos. Este dato se utiliza para enviar en el libro de sueldos digital el código correcto según la actividad del la empresa", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Situaciones de revista", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la sección de situaciones de revista de AFIP!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí puedes visualizar una lista de situaciones de revista definidas por AFIP con sus respectivos códigos. Este dato se utiliza para enviar en el libro de sueldos digital el código correcto según la situación de revista o licencia", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "AFIPConcepto", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la sección de conceptos de AFIP!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí puedes visualizar una lista de los conceptos definidos por AFIP con sus respectivos códigos. Los mismos deben ser asociados a los conceptos del sistema para el correcto funcionamiento del Libro de Sueldos Digital, accediendo desde el menú Liquidación > Conceptos", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Legajos", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la sección de legajos!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí puedes crear y administrar los datos de los legajos.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "LegajoINS", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de alta de legajo!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "En esta pantalla puedes definir todos los datos iniciales del nuevo legajo.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "LegajoUPD", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de modificación de legajo!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "En esta pantalla puedes editar todos los datos de un legajo existente.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "LegajoDLT", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de eliminación de legajo!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "En esta pantalla puedes chequear todos los datos de un legajo existente antes de confirmar la eliminación.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "LegajoDSP", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de visualización de legajo!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "En esta pantalla puedes visualizar todos los datos de un legajo existente. Para editar datos del mismo, haz click en \"Modificar\"", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Conceptos", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la sección de conceptos de nómina!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí puedes definir y administrar los elementos que afectan los recibos de sueldo. El sistema viene con un paquete de conceptos listos para usar con todo lo que necesitas, asegurando una nómina precisa y actualizada desde el primer momento. Además, los conceptos predefinidos se actualizan regularmente para estar al día con las novedades de las leyes nacionales y de convenio.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Periodos", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la sección de liquidaciones de nómina! ", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Este espacio te permite llevar a cabo el proceso de generación y gestión de las liquidaciones de sueldo de los empleados de manera eficiente y precisa. Desde aquí, podrás generar los recibos de sueldo correspondientes a cada periodo de pago, así como gestionar cualquier aspecto relacionado a los pagos asegurando la exactitud y la puntualidad en los pagos de los empleados.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Liquidaciones", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "Liquidaciones del periodo", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí podrás administrar las liquidaciones generadas en el periodo, modificarlas, ver y gestionar sus estados, re-procesarlas, como así también acceder a las herramientas de integración para pagos (pendiente!). Para ver el detalle de recibos generados haz click en el ícono de visualizar.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "LiquidacionLegajo", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "Recibos de la liquidación", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí podrás administrar y exportar a PDF en distintos formatos los recibos de la liquidación.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "LiquidacionRecibo", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "Detalle de recibo", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí podrás ver el detalle del recibo. Cada concepto cuenta con un log para poder apreciar exactamente paso a paso cómo se llegó a calcular cada importe. También puedes generar distintos formatos de recibos en PDF", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Exportar liquidaciones", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de exportación de liquidaciones!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí podrás exportar de manera eficiente y precisa las liquidaciones de sueldo de los empleados en diferentes formatos, facilitando la integración con otros sistemas y el cumplimiento de los requisitos legales.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Horas Trabajadas y Conceptos Adicionales", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de horas trabajadas y conceptos adicionales!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "En esta sección podrás registrar las horas trabajadas por los empleados, así como también gestionar cualquier concepto adicional relacionado con su salario, como horas extras, bonificaciones u otros incentivos.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Faltas y Llegadas Tarde", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Faltas y Llegadas Tarde! ", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí podrás registrar las faltas y llegadas tarde de los empleados, lo que permitirá llevar un control preciso de su asistencia y aplicar las correspondientes deducciones en sus salarios según las políticas de la empresa.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Vacaciones y Licencias", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Vacaciones y Licencias!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Esta pantalla te permite gestionar las vacaciones y licencias de los empleados de manera eficiente, que luego serán reflejadas en los recibos de sueldo. Podrás registrar las fechas de inicio y fin de las vacaciones, así como también cualquier tipo de licencia que soliciten los empleados, garantizando una adecuada planificación del personal.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Deducciones y Reintegros", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Deducciones y Reintegros!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí podrás administrar las deducciones y reintegros en los salarios de los empleados. Podrás registrar cualquier tipo de deducción, como descuentos por préstamos o anticipos, así como también gestionar los reintegros correspondientes, asegurando la precisión en los pagos.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Obligaciones", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Obligaciones!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "En esta sección podrás gestionar las obligaciones legales y fiscales relacionadas con la nómina de los empleados. Podrás estar al tanto de los impuestos y contribuciones que deben ser retenidos y abonados, así como también cumplir con cualquier otra obligación legal en materia de nómina.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Reportes", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Reportes!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Accede a reportes detallados sobre salarios, costos laborales, ausencias, horas trabajadas e impuestos retenidos. Información crucial para la toma de decisiones y cumplimiento normativo.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Convenios", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Convenios!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Selecciona los convenios laborales que apliquen a tu empresa, asegurando cumplimiento normativo y transparencia salarial. Visualiza las escalas salariales y particularidades de cada convenio como importes especiales y configuración de adicionales por tarea. Los datos de cada convenio reciben periodicamente las actualizaciones correspondientes según las novedades de los acuerdos vigentes.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Cálculos", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Cálculos!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Los cálculos predefinidos son palábras que se pueden utilizar en las fórmulas para resolver una gran cantidad de necesidades frecuentes.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Variables", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Variables!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Las variables son palabras que se pueden utilizar en las fórmulas y hacen referencia a valores específicos. Define variables personalizadas para adaptar el sistema a tus necesidades o usa las variables preexistentes que reciben frecuentes actualizaciones para estar al día.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Usuarios", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Usuarios!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Administra los usuarios y sus permisos de acceso al sistema. Gestiona usuarios y asigna permisos según roles, garantizando seguridad y control en el acceso a la plataforma de nómina.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Bancos", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Bancos!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "La lista de bancos predeterminados recibe actualizaciones periódicas. También puedes crear registros de bancos personalizados.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "EmpBancos", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Bancos de la empresa!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Acá podrás definir los bancos de la empresa. Luego podrás seleccionarlo como origen de los pagos previsionales, y para los pagos a los empleados, también en esta sección podrás administrar los diseños correspondientes de archivos para las transferencias.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Obras Sociales", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Obras Sociales!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Configura las obras sociales disponibles para los empleados. La lista de obras sociales predeterminadas recibe actualizaciones periódicas. También puedes crear registros de obras sociales personalizadas.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Sindicatos", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Sindicatos!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí puedes visualizar los distintos sindicatos disponibles.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Áreas", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Áreas!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Define las áreas organizativas de la empresa. Organiza la estructura interna de la empresa en áreas funcionales para una mejor gestión de recursos humanos y asignación de responsabilidades.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Puestos", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Puestos!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Registra los diferentes puestos de trabajo dentro de la empresa. Define los puestos de trabajo disponibles en la empresa, facilitando la asignación de roles y responsabilidades a los empleados.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Motivos de Egreso", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Motivos de Egreso!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí puedes configurar los motivos de egreso. Los más habituales están predefinidos y reciben actualizaciones según las normas vigentes.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Parámetros", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Parámetros!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Configura parámetros específicos para el funcionamiento del sistema. Define los parámetros necesarios para adaptar el sistema a las necesidades de la empresa, garantizando un proceso de nómina eficiente y preciso.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Impuesto a las Ganancias", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Impuesto a las Ganancias!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Administra el impuesto sobre las ganancias de los empleados. Gestiona y configura los detalles relacionados con el impuesto a las ganancias para asegurar el cumplimiento normativo y la exactitud en los cálculos fiscales.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Datos Principales", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Datos Principales de la empresa!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Gestiona los datos principales de la empresa, como su nombre, dirección y datos de contacto. Asegura que la información de la empresa esté actualizada y sea precisa.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Horas Extras", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Horas Extras!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí podrás configurar las políticas relacionadas a las horas extras: Porcentajes de aumentos por tipo de trabajo, y límites que determinan de a partir de qué cantidad de horas normales corresponde pagar horas extras. Los valores están predeterminados por las leyes vigentes del país, pero puedes personalizarlos dentro de ciertos límites aceptados legalmente.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Horas Extras Extraordinarias", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Horas Extras Extraordinarias!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí podrás configurar las políticas relacionadas a las horas extras especiales como fines de semana y feriados: Porcentajes de aumentos por tipo de trabajo, día y horario. Los valores están predeterminados por las leyes vigentes del país, pero puedes personalizarlos dentro de ciertos límites aceptados legalmente.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "OrigenesEmpresa", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Orígenes Reconocidos para Días No Laborables!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Administra los orígenes reconocidos para días no laborables. Registra y gestiona los días no laborables reconocidos por la empresa, facilitando la planificación y la gestión del calendario laboral en función de festividades y celebraciones.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "ReligionesEmpresa", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Religiones Reconocidas para Días No Laborables!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Gestiona las religiones reconocidas para días no laborables. Registra y actualiza las festividades religiosas que la empresa reconoce como días no laborables, garantizando la adecuada gestión del calendario laboral en función de las creencias religiosas de los empleados.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Licencias en Clase Jornal", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Licencias en Clase Jornal!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí podrás configurar las bases de cálculo para las licencias en empleados de clase jornal: Porcentajes de plus, cantidad de días o meses a promediar y parámetros de minimo y máximo de días, y otras configuraciones relacionadas al alta de las licencias por legajo. Los valores están predeterminados por las leyes vigentes del país, pero puedes personalizarlos dentro de ciertos límites aceptados legalmente.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Licencias en Clase Mensual", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Licencias en Clase Mensual!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí podrás configurar las bases de cálculo para las licencias en empleados de clase mensual: Porcentajes de plus, cantidad de días o meses a promediar y parámetros de minimo y máximo de días, y otras configuraciones relacionadas al alta de las licencias por legajo. Los valores están predeterminados por las leyes vigentes del país, pero puedes personalizarlos dentro de ciertos límites aceptados legalmente.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Feriados en Clase Jornal", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Feriados en Clase Jornal!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí podrás configurar las bases de cálculo para los feriados en empleados de clase jornal: Porcentajes de plus y cantidad de días o meses a promediar para feriados trabajados y no trabajados, y para días no laborables trabajados y no trabajados. Los valores están predeterminados por las leyes vigentes del país, pero puedes personalizarlos dentro de ciertos límites aceptados legalmente.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Feriados en Clase Mensual", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Feriados en Clase Mensual!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí podrás configurar las bases de cálculo para los feriados en empleados de clase mensual: Porcentajes de plus y cantidad de días o meses a promediar para feriados trabajados y no trabajados, y para días no laborables trabajados y no trabajados. Los valores están predeterminados por las leyes vigentes del país, pero puedes personalizarlos dentro de ciertos límites aceptados legalmente.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Hora Normal en Clase Jornal", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Hora Normal en Clase Jornal!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí debes definir la cantidad de tiempo a promediar para los conceptos que apliquen para la báse de cálculo de hora normal para legajos de clase jornal.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Hora Normal en Clase Mensual", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Hora Normal en Clase Mensual!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí debes definir la cantidad de tiempo a promediar para los conceptos que apliquen para la báse de cálculo de hora normal para legajos de clase mensual.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "A.R.T.", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de A.R.T.!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí podrás visualizar las distintas Aseguradoras de Riesgos del Trabajo (A.R.T.) que puedes asignar a tu empresa. Las mismas reciben actualizaciones periódicas para estar al día con el cumplimiento normativo en materia de seguridad laboral.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "AFIP", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de AFIP!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Administra la Administración Federal de Ingresos Públicos (AFIP). Configura y gestiona los datos fiscales de la empresa ante la AFIP, garantizando el cumplimiento de obligaciones tributarias y fiscales.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Agenda de Feriados", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Agenda de Feriados!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí podrás visualizar la agenda de feriados. El sistema recibirá actualizaciones periódicas para estar al día con los días festivos asegurando la planificación adecuada de actividades laborales y el cumplimiento de días no laborables.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Embargabilidad", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Embargabilidad!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí puedes visualizar las distintas lógicas de embargabilidad según las normas vigentes", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Estados / Licencias", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Estados/Licencias!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí puedes visualizar los distintos tipos de licencia y estados definidos por país. Esta lista se actualizará automáticamente para estar al día con la normativa, facilitando la gestión de ausencias y permisos del personal.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Estados Civiles", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Estados Civiles!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí podrás visualizar los posibles estados civiles de los empleados definidos por país. Los mismos facilitan la gestión de beneficios y deducciones relacionadas con el estado civil.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Localidades", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Localidades!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí puedes visualizar las localidades de las provincias del país", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Provincias", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Provincias!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí puedes visualizar las provincias del país", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Sexos", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Sexos!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Acá se listan los sexos a asignar a los empleados definidos por país.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Tipos de Obligación", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Tipos de Obligación!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí podrás visualizar los diferentes tipos de obligaciones fiscales y legales. Estos son los tipos de obligación posibles a cargar al dar de alta una nueva obligación en legajo.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Importar Liquidaciones Históricas", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Importar Liquidaciones Históricas!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí podrás importar datos de liquidaciones de sueldo históricas al sistema en 3 simples pasos, utilizando los mismos archivos que solicita la afip para Libro de Sueldos Digital", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Importar Legajos", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Importar Legajos!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí puedes importar legajos de otro sistema desde un excel, de ser necesario puedes modificar los datos que no tienen coincidencia en el sistema, o elegir que los mismos se creen automáticamente. Cuando los registros de importación estén sin errores puedes seleccionarlos para su incorporación definitiva", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Actualizaciones", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido a la pantalla de Actualizaciones!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí recibirás las actualizaciones que periódicamente reflejan la realidad cambiante de los cambios en convenios y nuevos valores oficiales relacionados a los impuestos de ley y ganancias, así como actualización de conceptos y datos generales", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Libro de Sueldos Digital", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido al Libro de Sueldos Digital de AFIP!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Accede al Libro de Sueldos Digital de AFIP para registrar y presentar información laboral de tus empleados de manera electrónica, cumpliendo con las regulaciones y obligaciones fiscales establecidas por la AFIP.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "PeriodoLSD", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido al Libro de Sueldos Digital de AFIP!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí puedes generar un archivo zip con los txts correspondientes a todas las liquidaciones del periodo, y visualizar por pantalla los datos de todos los registros generados.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "LiquidacionLSD", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido al Libro de Sueldos Digital de AFIP!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Aquí puedes generar un archivo txt con los registros de LSD de la liquidación, y visualizarlos por pantalla.", "") );
      Gxm1ini_bienvenida = (web.Sdtini_bienvenida_ini_bienvenidaItem)new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1ini_bienvenida, 0);
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid( httpContext.getMessage( "Formulario 1357", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef( httpContext.getMessage( "¡Bienvenido al Formulario 1357 de AFIP!", "") );
      Gxm1ini_bienvenida.setgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef( httpContext.getMessage( "Completa y presenta el Formulario 1357 de AFIP para declarar información laboral de empleados, como remuneraciones, retenciones y contribuciones, de forma precisa y conforme a las disposiciones fiscales vigentes.", "") );
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = textosbienvepredeterminados.this.Gxm2rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm2rootcol = new GXBaseCollection<web.Sdtini_bienvenida_ini_bienvenidaItem>(web.Sdtini_bienvenida_ini_bienvenidaItem.class, "ini_bienvenidaItem", "PayDay", remoteHandle);
      Gxm1ini_bienvenida = new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private GXBaseCollection<web.Sdtini_bienvenida_ini_bienvenidaItem>[] aP0 ;
   private GXBaseCollection<web.Sdtini_bienvenida_ini_bienvenidaItem> Gxm2rootcol ;
   private web.Sdtini_bienvenida_ini_bienvenidaItem Gxm1ini_bienvenida ;
}

