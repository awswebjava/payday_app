package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.search.*;
import java.sql.*;

public final  class aseccion_dataprovider extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(web.GXcfg.class);
      aseccion_dataprovider pgm = new aseccion_dataprovider (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {
      @SuppressWarnings("unchecked")
      GXBCCollection<web.SdtSeccion>[] aP0 = new GXBCCollection[] {new GXBCCollection<web.SdtSeccion>()};

      try
      {
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      execute(aP0);
   }

   public aseccion_dataprovider( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( aseccion_dataprovider.class ), "" );
   }

   public aseccion_dataprovider( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBCCollection<web.SdtSeccion> executeUdp( )
   {
      aseccion_dataprovider.this.aP0 = new GXBCCollection[] {new GXBCCollection<web.SdtSeccion>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBCCollection<web.SdtSeccion>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBCCollection<web.SdtSeccion>[] aP0 )
   {
      aseccion_dataprovider.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      Gxm1seccion = (web.SdtSeccion)new web.SdtSeccion( remoteHandle, context);
      Gxm2rootcol.add(Gxm1seccion, 0);
      Gxm1seccion.setgxTv_SdtSeccion_Clicod( 0 );
      Gxm1seccion.setgxTv_SdtSeccion_Seccodigo( "001" );
      Gxm1seccion.setgxTv_SdtSeccion_Secdescrip( httpContext.getMessage( "Gestión de Proyectos", "") );
      Gxm1seccion.setgxTv_SdtSeccion_Sechabilitada( true );
      Gxm1seccion.setgxTv_SdtSeccion_Secapoopc( false );
      Gxm1seccion = (web.SdtSeccion)new web.SdtSeccion( remoteHandle, context);
      Gxm2rootcol.add(Gxm1seccion, 0);
      Gxm1seccion.setgxTv_SdtSeccion_Clicod( 0 );
      Gxm1seccion.setgxTv_SdtSeccion_Seccodigo( "002" );
      Gxm1seccion.setgxTv_SdtSeccion_Secdescrip( httpContext.getMessage( "Recursos Humanos", "") );
      Gxm1seccion.setgxTv_SdtSeccion_Sechabilitada( true );
      Gxm1seccion.setgxTv_SdtSeccion_Secapoopc( false );
      Gxm1seccion = (web.SdtSeccion)new web.SdtSeccion( remoteHandle, context);
      Gxm2rootcol.add(Gxm1seccion, 0);
      Gxm1seccion.setgxTv_SdtSeccion_Clicod( 0 );
      Gxm1seccion.setgxTv_SdtSeccion_Seccodigo( "003" );
      Gxm1seccion.setgxTv_SdtSeccion_Secdescrip( httpContext.getMessage( "Salud y Seguridad Laboral", "") );
      Gxm1seccion.setgxTv_SdtSeccion_Sechabilitada( true );
      Gxm1seccion.setgxTv_SdtSeccion_Secapoopc( false );
      Gxm1seccion = (web.SdtSeccion)new web.SdtSeccion( remoteHandle, context);
      Gxm2rootcol.add(Gxm1seccion, 0);
      Gxm1seccion.setgxTv_SdtSeccion_Clicod( 0 );
      Gxm1seccion.setgxTv_SdtSeccion_Seccodigo( "004" );
      Gxm1seccion.setgxTv_SdtSeccion_Secdescrip( httpContext.getMessage( "Planificación y Programación de Proyectos", "") );
      Gxm1seccion.setgxTv_SdtSeccion_Sechabilitada( true );
      Gxm1seccion.setgxTv_SdtSeccion_Secapoopc( false );
      Gxm1seccion = (web.SdtSeccion)new web.SdtSeccion( remoteHandle, context);
      Gxm2rootcol.add(Gxm1seccion, 0);
      Gxm1seccion.setgxTv_SdtSeccion_Clicod( 0 );
      Gxm1seccion.setgxTv_SdtSeccion_Seccodigo( "005" );
      Gxm1seccion.setgxTv_SdtSeccion_Secdescrip( httpContext.getMessage( "Construcción y Operaciones", "") );
      Gxm1seccion.setgxTv_SdtSeccion_Sechabilitada( true );
      Gxm1seccion.setgxTv_SdtSeccion_Secapoopc( false );
      Gxm1seccion = (web.SdtSeccion)new web.SdtSeccion( remoteHandle, context);
      Gxm2rootcol.add(Gxm1seccion, 0);
      Gxm1seccion.setgxTv_SdtSeccion_Clicod( 0 );
      Gxm1seccion.setgxTv_SdtSeccion_Seccodigo( "006" );
      Gxm1seccion.setgxTv_SdtSeccion_Secdescrip( httpContext.getMessage( "Presupuestación", "") );
      Gxm1seccion.setgxTv_SdtSeccion_Sechabilitada( true );
      Gxm1seccion.setgxTv_SdtSeccion_Secapoopc( false );
      Gxm1seccion = (web.SdtSeccion)new web.SdtSeccion( remoteHandle, context);
      Gxm2rootcol.add(Gxm1seccion, 0);
      Gxm1seccion.setgxTv_SdtSeccion_Clicod( 0 );
      Gxm1seccion.setgxTv_SdtSeccion_Seccodigo( "007" );
      Gxm1seccion.setgxTv_SdtSeccion_Secdescrip( httpContext.getMessage( "Relaciones con Clientes", "") );
      Gxm1seccion.setgxTv_SdtSeccion_Sechabilitada( true );
      Gxm1seccion.setgxTv_SdtSeccion_Secapoopc( false );
      Gxm1seccion = (web.SdtSeccion)new web.SdtSeccion( remoteHandle, context);
      Gxm2rootcol.add(Gxm1seccion, 0);
      Gxm1seccion.setgxTv_SdtSeccion_Clicod( 0 );
      Gxm1seccion.setgxTv_SdtSeccion_Seccodigo( "008" );
      Gxm1seccion.setgxTv_SdtSeccion_Secdescrip( httpContext.getMessage( "Gerencia General", "") );
      Gxm1seccion.setgxTv_SdtSeccion_Sechabilitada( true );
      Gxm1seccion.setgxTv_SdtSeccion_Secapoopc( false );
      Gxm1seccion = (web.SdtSeccion)new web.SdtSeccion( remoteHandle, context);
      Gxm2rootcol.add(Gxm1seccion, 0);
      Gxm1seccion.setgxTv_SdtSeccion_Clicod( 0 );
      Gxm1seccion.setgxTv_SdtSeccion_Seccodigo( "009" );
      Gxm1seccion.setgxTv_SdtSeccion_Secdescrip( httpContext.getMessage( "Control de calidad", "") );
      Gxm1seccion.setgxTv_SdtSeccion_Sechabilitada( true );
      Gxm1seccion.setgxTv_SdtSeccion_Secapoopc( false );
      Gxm1seccion = (web.SdtSeccion)new web.SdtSeccion( remoteHandle, context);
      Gxm2rootcol.add(Gxm1seccion, 0);
      Gxm1seccion.setgxTv_SdtSeccion_Clicod( 0 );
      Gxm1seccion.setgxTv_SdtSeccion_Seccodigo( "010" );
      Gxm1seccion.setgxTv_SdtSeccion_Secdescrip( httpContext.getMessage( "Sistemas", "") );
      Gxm1seccion.setgxTv_SdtSeccion_Sechabilitada( true );
      Gxm1seccion.setgxTv_SdtSeccion_Secapoopc( false );
      Gxm1seccion = (web.SdtSeccion)new web.SdtSeccion( remoteHandle, context);
      Gxm2rootcol.add(Gxm1seccion, 0);
      Gxm1seccion.setgxTv_SdtSeccion_Clicod( 0 );
      Gxm1seccion.setgxTv_SdtSeccion_Seccodigo( "011" );
      Gxm1seccion.setgxTv_SdtSeccion_Secdescrip( httpContext.getMessage( "Dirección", "") );
      Gxm1seccion.setgxTv_SdtSeccion_Sechabilitada( true );
      Gxm1seccion.setgxTv_SdtSeccion_Secapoopc( true );
      cleanup();
   }

   public static Object refClasses( )
   {
      GXutil.refClasses(seccion_dataprovider.class);
      return new web.GXcfg();
   }

   protected void cleanup( )
   {
      this.aP0[0] = aseccion_dataprovider.this.Gxm2rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm2rootcol = new GXBCCollection<web.SdtSeccion>(web.SdtSeccion.class, "Seccion", "PayDay", remoteHandle);
      Gxm1seccion = new web.SdtSeccion(remoteHandle);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private GXBCCollection<web.SdtSeccion>[] aP0 ;
   private GXBCCollection<web.SdtSeccion> Gxm2rootcol ;
   private web.SdtSeccion Gxm1seccion ;
}

