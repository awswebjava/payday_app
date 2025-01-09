package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class initests extends GXProcedure
{
   public initests( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( initests.class ), "" );
   }

   public initests( int remoteHandle ,
                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( )
   {
      execute_int();
   }

   private void execute_int( )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized DELETE. */
      cmdBuffer = " LOCK TABLE Test IN EXCLUSIVE MODE ";
      ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      /* Using cursor P016I2 */
      pr_default.execute(0);
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Test");
      /* End optimized DELETE. */
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 1", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(1) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(2) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 1 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Prueba ", "")+GXutil.trim( GXutil.str( AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Nro(), 4, 0))+httpContext.getMessage( " Sofia garcia (mensual fuera de categoria sueldo 1000000). De enero a mayo. Tiene vacaciones del 1 al 14 de mayo, pero las cobra por adelantado en abril liquidandolas en la misma liquidacion mensual de abril. Comparar con la siguiente, tiene que dar igual.", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Iigg( true );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 2", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(2) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(1) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 1 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( false );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Prueba ", "")+GXutil.trim( GXutil.str( AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Nro(), 4, 0))+httpContext.getMessage( " Ana Valdez (mensual fuera de categoria sueldo 1000000). De enero a mayo. Tiene vacaciones del 1 al 14 de mayo, pero las cobra por adelantado en abril en una liquidación separada de adelanto de vacaciones posterior a la mensual de abril. Comparar con la anterior, tiene que dar igual.", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Iigg( true );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 3", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(3) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(4) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 1 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Prueba ", "")+GXutil.trim( GXutil.str( AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Nro(), 4, 0))+httpContext.getMessage( " Sofia garcia (mensual fuera de categoria sueldo 1000000). De enero a junio. Tiene vacaciones del 1 al 14 de mayo, pero las cobra por adelantado en abril liquidandolas en la misma liquidacion mensual de abril. Comparar con la prueba 4 y la prueba 9, tienen que dar igual.", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Iigg( true );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 4", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(4) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(3) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 1 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( false );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Prueba ", "")+GXutil.trim( GXutil.str( AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Nro(), 4, 0))+httpContext.getMessage( " Ana Valdez (mensual fuera de categoria sueldo 1000000). De enero a junio. Tiene vacaciones del 1 al 14 de mayo, pero las cobra por adelantado en abril en una liquidación separada de adelanto de vacaciones posterior a la mensual de abril. Comparar con la anterior, tiene que dar igual.", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Iigg( true );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 5 (33?", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(5) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(3) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 1 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Prueba ", "")+GXutil.trim( GXutil.str( AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Nro(), 4, 0))+httpContext.getMessage( " Ana valdez(mensual fuera de categoria sueldo 1000000). De enero a junio. Tiene vacaciones del 1 al 14 de mayo. Sin adelanto de vacaciones. Tiene que dar igual a la 3", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Iigg( true );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 6", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(6) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(5) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 2 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( false );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "(****Esta hay que revisarla con mas detenimiento porque es jornal vs mensual, da diferente...)  Prueba ", "")+GXutil.trim( GXutil.str( AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Nro(), 4, 0))+httpContext.getMessage( " Daniel Romero Jornal fuera de convenio sin sindicato valor hora 100000 primera quincena 500000 y segunda quincena 500000. De enero a junio. Tiene vacaciones del 1 al 14 de mayo. Sin adelanto de vacaciones. Tiene que dar igual a la 5", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Iigg( true );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 7", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(7) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(8) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 1 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 2 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Prueba ", "")+GXutil.trim( GXutil.str( AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Nro(), 4, 0))+httpContext.getMessage( " Sofia garcia (mensual fuera de categoria sueldo 1000000). Todo el año. Comparar con la siguiente, tiene que dar igual. Usa la variable auxiliar de meses", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Iigg( true );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 8", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(8) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(7) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 2 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 1 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( false );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Prueba ", "")+GXutil.trim( GXutil.str( AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Nro(), 4, 0))+httpContext.getMessage( " Daniel Romero Jornal fuera de convenio sin sindicato valor hora 100000 primera quincena 500000 y segunda quincena 500000. Comparar con la anterior, tiene que dar igual.. Usa la variable auxiliar de meses", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Iigg( true );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 9", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(9) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(4) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 1 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Prueba ", "")+GXutil.trim( GXutil.str( AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Nro(), 4, 0))+httpContext.getMessage( " Sofia garcia (mensual fuera de categoria sueldo 1000000). De enero a junio, con adelanto de aguinaldo. Tiene vacaciones del 1 al 14 de mayo, pero las cobra por adelantado en abril liquidandolas en la misma liquidacion mensual de abril. Comparar con la prueba 4, tiene que dar igual.", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Iigg( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 10", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(10) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(11) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 1 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Prueba ", "")+GXutil.trim( GXutil.str( AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Nro(), 4, 0))+httpContext.getMessage( " Sofia garcia (mensual fuera de categoria sueldo 1000000). De enero a DICIEMBRE (así se aplique ganancias en la ultima liquidación de junio que es de aguinaldo, y hasta diciembre para que se apliquen los prorateos del bono en ganancias), con adelanto de aguinaldo, pero después del adelanto de aguinaldo le suben el sueldo a 1500000 y le liquidan junio con aguinaldo extra. Luego se liquida \"Varios\" con bono por productividad de 900000 (que es totalmente gravado porque el bruto promedio es más que el tope). Luego se vuelve a liquidar aguinaldo para quese actualice con el sueldo con bono. Para la liquidación de julio se le aumenta el sueldo a 2400000. Tiene vacaciones del 1 al 14 de mayo, pero las cobra por adelantado en abril liquidandolas en la misma liquidacion mensual de abril. Comparar con la 11.", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Iigg( true );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 11", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(11) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(10) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 1 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( false );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Prueba ", "")+GXutil.trim( GXutil.str( AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Nro(), 4, 0))+httpContext.getMessage( " Ana Valdez (mensual fuera de categoria sueldo 1000000). De enero a DICIEMBRE (para que sea compatible con la prueba 10). Tiene vacaciones del 1 al 14 de mayo. Sin adelantos de aguinaldo ni adelanto de vacaciones. En junio le aumentan a 2400000. Tiene que dar igual que la 10", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Iigg( true );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 12", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(12) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(6) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 4 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 2 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Prueba ", "")+GXutil.trim( GXutil.str( AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Nro(), 4, 0))+httpContext.getMessage( " Lucas Torres Jornal fuera de convenio sin sindicato valor hora 100000 primera quincena 500000 y segunda quincena 500000. De enero a junio. Tiene vacaciones del 1 al 14 de mayo. Con adelanto de las vacaciones incluido en la segunda quincena de abril. Tiene que dar igual a la 6", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 13", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(13) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(0) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 1 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 0 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Prueba ", "")+GXutil.trim( GXutil.str( AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Nro(), 4, 0))+httpContext.getMessage( " Sofia garcia Lo mismo que la prueba 10, pero le cambiamos el tope de excencion bonos a 10 millones para que tenga parte del bono exento (no se compara con ninguna prueba)", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 14", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(14) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(0) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 0 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Prueba ", "")+GXutil.trim( GXutil.str( AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Nro(), 4, 0))+httpContext.getMessage( " Ana valdez, de enero a diciembre. (prueba aislada sin comparar con otra) le dan bono de productividad de 900000 (900mil) en junio (totalmente gravado). Es para ver si prorratea bien el bono en un escenario donde no hay liquidaciones adicionales a las mensuales", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 15", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(15) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(0) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 0 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Prueba ", "")+GXutil.trim( GXutil.str( AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Nro(), 4, 0))+httpContext.getMessage( " Ana valdez, de enero a diciembre. (prueba aislada sin comparar con otra) le dan bono de productividad de 900000 (900mil) en junio (parcialmente gravada porque le subo el tope de excención). Es para ver si prorratea bien el bono en un escenario donde no hay liquidaciones adicionales a las mensuales", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 16", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(16) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(0) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 2 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 0 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Prueba ", "")+GXutil.trim( GXutil.str( AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Nro(), 4, 0))+httpContext.getMessage( " Daniel Romero , de enero a diciembre. (prueba aislada sin comparar con otra) le dan bono de productividad de 900000 (900mil) en la segunda quincena junio (totalmente gravado). Es para ver si prorratea bien el bono en un escenario donde no hay liquidaciones adicionales a las mensuales en empleado jornal", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 17", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(17) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(0) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 2 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 0 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Prueba ", "")+GXutil.trim( GXutil.str( AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Nro(), 4, 0))+httpContext.getMessage( " Daniel Romero , de enero a diciembre. (prueba aislada sin comparar con otra) le dan bono de productividad de 900000 (900mil) en la PRIMERA quincena junio (totalmente gravado). Es para ver si prorratea bien el bono en un escenario donde no hay liquidaciones adicionales a las mensuales en empleado jornal", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 18", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(18) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(0) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 0 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Prueba ", "")+GXutil.trim( GXutil.str( AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Nro(), 4, 0))+httpContext.getMessage( " Ana valdez, de enero a agosto (renuncia). (prueba aislada sin comparar con otra) le dan bono de productividad de 900000 (900mil) en junio (totalmente gravado). Es para ver si prorratea bien el bono en un escenario donde no hay liquidaciones adicionales a las mensuales y hay un egreso", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 19", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(19) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(0) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 0 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Prueba ", "")+GXutil.trim( GXutil.str( AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Nro(), 4, 0))+httpContext.getMessage( " Ana valdez, todo el año. 2 BONOS, 1 en abril y otro en septiembre 900000 (900mil). Total 1800000 1millon 8cientos", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 20", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(20) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(21) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 2 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 4 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Prueba ", "")+GXutil.trim( GXutil.str( AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Nro(), 4, 0))+httpContext.getMessage( " Daniel romero. Jornal fuera de convenio. Enero 100 hs de 5000p cada una horas,  las 2 quincenas, y 100 horas la segunda de febrero.  Tiene vacaciones del 1 al 15 de febrero, con liqidación de adelanto antes de liquidar la primera de febrero. Tiene que dar igual a la 21", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 21", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(21) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(20) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 4 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 2 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( false );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Prueba ", "")+GXutil.trim( GXutil.str( AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Nro(), 4, 0))+httpContext.getMessage( " Torres Lucas. Jornal fuera de convenio. Enero 100 hs de 5000p cada una horas,  las 2 quincenas, y 100 horas la segunda de febrero. Tiene vacaciones del 1 al 15 de febrero, sin liquidación de adelanto. Tiene que dar igual a la 20", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 22", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(22) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(23) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 1 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Prueba 22. Sofia garcia. Todo el año. Enero tiene deducción de empleada doméstica por 300000. MNI es 200000 para los 2 meses. En diciembre sube el MNI a 400000. Tiene que dar igual a prueba 23", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 23", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(23) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(22) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 1 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( false );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Prueba 23. Ana valdez. Todo el año. Enero tiene deducción de empleada doméstica por 300000. MNI es 200000 para enero y 400000 para febrero pero no retroactivo. Tiene que dar igual a prueba 22. ", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 24", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(24) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(25) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 1 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Prueba 24. Sofia garcia. Enero y febrero. Enero tiene deducción de empleada doméstica por 300000. MNI es 200000 para enero y 400000 para febrero (retroactivo a enero). Tiene que dar igual a prueba 25. ", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 25", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(25) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(24) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 1 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( false );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Ana valdez. Enero y febrero. Enero tiene deducción de empleada doméstica por 300000. MNI es 400000 desde enero. Tiene que dar igual a prueba 24. ", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 26", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(26) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(27) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 1 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Todo el año. Legajo 1. En febrero cobra bono por productividad de 900000. El tope de bonos 3000000. El mni está en 1000000, por lo que 400000 le queda excento y 500000 le queda gravado. En diciembre el mni sube a 2000000 retroactivo a enero, por lo que debería tener exento 800000 y gravar solo 100000. Las cuotas de prorrateo de a partir de abril deberían acomodarse a la nueva realidad. Tieneq que dar igual a prueba 27", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 27", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(27) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(26) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 1 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( false );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Prueba 27. Ana valdez. Igual que prueba 26 pero desde enero tiene el MNI en 2000000. Tiene que dar igual a prueba 26", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 28", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(28) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(19) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 1 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Prueba 28. Sofia García. Igual que prueba 19 pero los 2 bonos de 900mil se lo dan en enero.  Tiene que dar igual a prueba 19", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 29", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(29) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(30) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 1 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Sofía garcía de enero a junio con sueldo de 1000000. Tiene que dar igual a la prueba 30", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 30", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(30) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(29) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 1 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Ana Valdez, de enero a junio. Hasta abril tiene sueldo de 1000000. En mayo sueldo de 250000. Primero en mayo una liquidacion de VARIOS con 250000, luego la mensual, luego otras 2 de 250000. Junio vuelve a sueldo 1000000. Se compara con la 29", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 31", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(31) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(5) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 1 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Sofia garcia, (mensual fuera de categoria sueldo 1000000). De enero a junio. Tiene vacaciones del 1 al 14 de mayo. Tiene adelanto de vacaciones \"mes actual\" antes de la mensual. Tiene que dar igual a la 5", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 32", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(32) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(6) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 4 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 2 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Prueba ", "")+GXutil.trim( GXutil.str( AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Nro(), 4, 0))+httpContext.getMessage( " Lucas Torres Jornal fuera de convenio sin sindicato valor hora 100000 primera quincena 500000 y segunda quincena 500000. De enero a junio. Tiene vacaciones del 1 al 10 de mayo. Con adelanto de vacaciones antes de la primera quincena. Tiene que dar igual a la 6", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 33", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(33) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(1) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 1 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Prueba ", "")+GXutil.trim( GXutil.str( AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Nro(), 4, 0))+httpContext.getMessage( ". Valdez Como la prueba 1, pero en vez de adelantar los 14 dias, adelanta 7", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 34", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(34) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(2) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 1 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Prueba ", "")+GXutil.trim( GXutil.str( AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Nro(), 4, 0))+httpContext.getMessage( ". Sofía Como la prueba 2, pero en vez de adelantar los 14 dias, adelanta 7", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 35", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(35) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(7) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 1 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "***ver porqué siempre falla en la primera..... Prueba ", "")+GXutil.trim( GXutil.str( AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Nro(), 4, 0))+httpContext.getMessage( ". Ana valdez con sueldo de 900000, y 100000 de otros empleos cargado en siradig. La retencion de ganancias tiene que dar igual que prueba 7 (no así el neto, ni el bruto)", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 36", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(36) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(0) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 2 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 0 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Prueba ", "")+GXutil.trim( GXutil.str( AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Nro(), 4, 0))+httpContext.getMessage( ". Daniel Romero en la primera quincena enero tiene 15 horas extras al 50%, en la segunda de febrero 10 horas extras al 100%. En marzo 14 días de vacaciones. Es para ver que calcule la remuneración variable para el día de vacación.****** Lo cambio a que las 2 hras extras sean al 50% para que me lo tome como habitual", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 37", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(37) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(0) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 0 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Prueba ", "")+GXutil.trim( GXutil.str( AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Nro(), 4, 0))+httpContext.getMessage( ". Ana valdez con sueldo de 1000000. Licencia por enfermedad del 1 al 3 de enero. ILT primeros 10 días desde el 15/02 al 25/02. ILT por ART del 1 al 20 de abril. ", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 38", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(38) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(0) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 0 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Como la prueba 18 pero con despido con causa", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 39", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(39) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(0) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 0 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Como la prueba 18 pero con despido sin causa con preaviso", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 40", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(40) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(0) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 0 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Como la prueba 18 pero con despido sin causa y sin preaviso", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 41", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(41) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(0) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 0 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Como la prueba 40 pero el egreso es el 28 de octubre (para que liquide vacaciones no gozadas)", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 42", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(42) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(0) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 2 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 0 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Como la prueba 41 pero con legajo daniel romero con convenio uecara y categoria)", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 43", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(43) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(0) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 2 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 0 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Como la prueba 41 pero con legajo daniel romero con convenio uocra y categoria)", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 44", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(44) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(7) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 0 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Ana Valdez. Anticipo de 400000 en abril (4 cientos mil) a pagar en 3 cuotas. Tiene que dar igual que la 7", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 45", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(45) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(7) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 0 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Ana Valdez. Anticipo de 400000 en abril (4 cientos mil) a pagar en cuotas de 50mil. Tiene que dar igual que la 7", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV9itemPruebas = (web.Sdtsdt_pruebas)new web.Sdtsdt_pruebas(remoteHandle, context);
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nombre( httpContext.getMessage( "Prueba 46", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Nro( (short)(46) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testnro2( (short)(7) );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero1( 3 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testlegnumero2( 0 );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testprobartodos( true );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Descripcion( httpContext.getMessage( "Ana Valdez. Anticipo de 400000 en abril (4 cientos mil) a pagar en cuotas de 10% del sueldo (remunerativos y no remunerativos excluyendo sac). Tiene que dar igual que la 7", "") );
      AV9itemPruebas.setgxTv_Sdtsdt_pruebas_Testbono( ((0==AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2()) ? true : false) );
      AV8sdt_pruebass.add(AV9itemPruebas, 0);
      AV21GXV1 = 1 ;
      while ( AV21GXV1 <= AV8sdt_pruebass.size() )
      {
         AV9itemPruebas = (web.Sdtsdt_pruebas)((web.Sdtsdt_pruebas)AV8sdt_pruebass.elementAt(-1+AV21GXV1));
         /*
            INSERT RECORD ON TABLE Test

         */
         A1083TestNro = AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Nro() ;
         A1084TestOK = false ;
         A1085TestFechaHora = GXutil.resetTime( GXutil.nullDate() );
         A1086TestNombre = AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Nombre() ;
         A1087TestDescripcion = AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Descripcion() ;
         A1088TestSegLiq = (short)(0) ;
         A1089TestSegTotal = (short)(0) ;
         A1090TestVueltas = (short)(0) ;
         A1204TestLegNumero1 = AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testlegnumero1() ;
         A1205TestLegNumero2 = AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testlegnumero2() ;
         A1206TestNro2 = AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testnro2() ;
         A1208TestProbarTodos = AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testprobartodos() ;
         A1209TestBono = AV9itemPruebas.getgxTv_Sdtsdt_pruebas_Testbono() ;
         A1091TestError = "" ;
         A1092TestNeto = DecimalUtil.ZERO ;
         A1093TestIIGG = DecimalUtil.ZERO ;
         A1096TestTipo = (short)(0) ;
         /* Using cursor P016I3 */
         pr_default.execute(1, new Object[] {Short.valueOf(A1083TestNro), Boolean.valueOf(A1084TestOK), A1085TestFechaHora, A1086TestNombre, A1087TestDescripcion, Short.valueOf(A1088TestSegLiq), Short.valueOf(A1089TestSegTotal), Short.valueOf(A1090TestVueltas), A1091TestError, A1092TestNeto, A1093TestIIGG, Short.valueOf(A1096TestTipo), Integer.valueOf(A1204TestLegNumero1), Integer.valueOf(A1205TestLegNumero2), Short.valueOf(A1206TestNro2), Boolean.valueOf(A1208TestProbarTodos), Boolean.valueOf(A1209TestBono)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Test");
         if ( (pr_default.getStatus(1) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         AV21GXV1 = (int)(AV21GXV1+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "initests");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      cmdBuffer = "" ;
      AV9itemPruebas = new web.Sdtsdt_pruebas(remoteHandle, context);
      AV8sdt_pruebass = new GXBaseCollection<web.Sdtsdt_pruebas>(web.Sdtsdt_pruebas.class, "sdt_pruebas", "PayDay", remoteHandle);
      A1085TestFechaHora = GXutil.resetTime( GXutil.nullDate() );
      A1086TestNombre = "" ;
      A1087TestDescripcion = "" ;
      A1091TestError = "" ;
      A1092TestNeto = DecimalUtil.ZERO ;
      A1093TestIIGG = DecimalUtil.ZERO ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.initests__default(),
         new Object[] {
             new Object[] {
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A1083TestNro ;
   private short A1088TestSegLiq ;
   private short A1089TestSegTotal ;
   private short A1090TestVueltas ;
   private short A1206TestNro2 ;
   private short A1096TestTipo ;
   private short Gx_err ;
   private int AV21GXV1 ;
   private int GX_INS121 ;
   private int A1204TestLegNumero1 ;
   private int A1205TestLegNumero2 ;
   private java.math.BigDecimal A1092TestNeto ;
   private java.math.BigDecimal A1093TestIIGG ;
   private String cmdBuffer ;
   private String A1086TestNombre ;
   private String Gx_emsg ;
   private java.util.Date A1085TestFechaHora ;
   private boolean A1084TestOK ;
   private boolean A1208TestProbarTodos ;
   private boolean A1209TestBono ;
   private String A1087TestDescripcion ;
   private String A1091TestError ;
   private IDataStoreProvider pr_default ;
   private GXBaseCollection<web.Sdtsdt_pruebas> AV8sdt_pruebass ;
   private web.Sdtsdt_pruebas AV9itemPruebas ;
}

final  class initests__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P016I2", "DELETE FROM Test ", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P016I3", "SAVEPOINT gxupdate;INSERT INTO Test(TestNro, TestOK, TestFechaHora, TestNombre, TestDescripcion, TestSegLiq, TestSegTotal, TestVueltas, TestError, TestNeto, TestIIGG, TestTipo, TestLegNumero1, TestLegNumero2, TestNro2, TestProbarTodos, TestBono) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setBoolean(2, ((Boolean) parms[1]).booleanValue());
               stmt.setDateTime(3, (java.util.Date)parms[2], false);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setVarchar(5, (String)parms[4], 1000, false);
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setVarchar(9, (String)parms[8], 400, false);
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[9], 2);
               stmt.setBigDecimal(11, (java.math.BigDecimal)parms[10], 2);
               stmt.setShort(12, ((Number) parms[11]).shortValue());
               stmt.setInt(13, ((Number) parms[12]).intValue());
               stmt.setInt(14, ((Number) parms[13]).intValue());
               stmt.setShort(15, ((Number) parms[14]).shortValue());
               stmt.setBoolean(16, ((Boolean) parms[15]).booleanValue());
               stmt.setBoolean(17, ((Boolean) parms[16]).booleanValue());
               return;
      }
   }

}

