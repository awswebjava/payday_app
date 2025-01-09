package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.search.*;
import java.sql.*;

public final  class amotivoegreso_dataprovider extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(web.GXcfg.class);
      amotivoegreso_dataprovider pgm = new amotivoegreso_dataprovider (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {
      @SuppressWarnings("unchecked")
      GXBCCollection<web.SdtMotivoEgreso>[] aP0 = new GXBCCollection[] {new GXBCCollection<web.SdtMotivoEgreso>()};

      try
      {
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      execute(aP0);
   }

   public amotivoegreso_dataprovider( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( amotivoegreso_dataprovider.class ), "" );
   }

   public amotivoegreso_dataprovider( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBCCollection<web.SdtMotivoEgreso> executeUdp( )
   {
      amotivoegreso_dataprovider.this.aP0 = new GXBCCollection[] {new GXBCCollection<web.SdtMotivoEgreso>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBCCollection<web.SdtMotivoEgreso>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBCCollection<web.SdtMotivoEgreso>[] aP0 )
   {
      amotivoegreso_dataprovider.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      Gxm1motivoegreso = (web.SdtMotivoEgreso)new web.SdtMotivoEgreso( remoteHandle, context);
      Gxm2rootcol.add(Gxm1motivoegreso, 0);
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Clicod( 0 );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megcodigo( httpContext.getMessage( "FUE", "") );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megdescrip( httpContext.getMessage( "POR FUERZA MAYOR, FALTA O DISMINUCIÓN DE TRABAJO", "") );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Meghabilitado( true );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megres551( "12" );
      Gxm1motivoegreso = (web.SdtMotivoEgreso)new web.SdtMotivoEgreso( remoteHandle, context);
      Gxm2rootcol.add(Gxm1motivoegreso, 0);
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Clicod( 0 );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megcodigo( httpContext.getMessage( "MAT", "") );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megdescrip( httpContext.getMessage( "RENUNCIA TRABAJADORA AL FINALIZAR LICENCIA POR MATERNIDAD", "") );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Meghabilitado( true );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megres551( "12" );
      Gxm1motivoegreso = (web.SdtMotivoEgreso)new web.SdtMotivoEgreso( remoteHandle, context);
      Gxm2rootcol.add(Gxm1motivoegreso, 0);
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Clicod( 0 );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megcodigo( httpContext.getMessage( "QU1", "") );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megdescrip( httpContext.getMessage( "POR QUIEBRA O CONCURSO DEL EMPLEADOR, IMPUTABLE AL EMPLEADOR", "") );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Meghabilitado( true );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megres551( "12" );
      Gxm1motivoegreso = (web.SdtMotivoEgreso)new web.SdtMotivoEgreso( remoteHandle, context);
      Gxm2rootcol.add(Gxm1motivoegreso, 0);
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Clicod( 0 );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megcodigo( httpContext.getMessage( "QU2", "") );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megdescrip( httpContext.getMessage( "POR QUIEBRA O CONCURSO DEL EMPLEADOR, NO IMPUTABLE AL EMPLEADOR", "") );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Meghabilitado( true );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megres551( "12" );
      Gxm1motivoegreso = (web.SdtMotivoEgreso)new web.SdtMotivoEgreso( remoteHandle, context);
      Gxm2rootcol.add(Gxm1motivoegreso, 0);
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Clicod( 0 );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megcodigo( httpContext.getMessage( "MUE", "") );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megdescrip( httpContext.getMessage( "FALLECIMIENTO DEL EMPLEADOR", "") );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Meghabilitado( true );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megres551( "12" );
      Gxm1motivoegreso = (web.SdtMotivoEgreso)new web.SdtMotivoEgreso( remoteHandle, context);
      Gxm2rootcol.add(Gxm1motivoegreso, 0);
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Clicod( 0 );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megcodigo( httpContext.getMessage( "VTO", "") );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megdescrip( httpContext.getMessage( "VENCIMIENTO CONTRATO", "") );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Meghabilitado( true );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megres551( "12" );
      Gxm1motivoegreso = (web.SdtMotivoEgreso)new web.SdtMotivoEgreso( remoteHandle, context);
      Gxm2rootcol.add(Gxm1motivoegreso, 0);
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Clicod( 0 );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megcodigo( httpContext.getMessage( "ABA", "") );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megdescrip( httpContext.getMessage( "ABANDONO DE TRABAJO", "") );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Meghabilitado( true );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megres551( "12" );
      Gxm1motivoegreso = (web.SdtMotivoEgreso)new web.SdtMotivoEgreso( remoteHandle, context);
      Gxm2rootcol.add(Gxm1motivoegreso, 0);
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Clicod( 0 );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megcodigo( httpContext.getMessage( "BOC", "") );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megdescrip( httpContext.getMessage( "BAJAS OTRAS CAUSALES", "") );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Meghabilitado( true );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megres551( "12" );
      Gxm1motivoegreso = (web.SdtMotivoEgreso)new web.SdtMotivoEgreso( remoteHandle, context);
      Gxm2rootcol.add(Gxm1motivoegreso, 0);
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Clicod( 0 );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megcodigo( httpContext.getMessage( "DES1", "") );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megdescrip( httpContext.getMessage( "DESPIDO CON CAUSA", "") );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Meghabilitado( true );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megres551( "12" );
      Gxm1motivoegreso = (web.SdtMotivoEgreso)new web.SdtMotivoEgreso( remoteHandle, context);
      Gxm2rootcol.add(Gxm1motivoegreso, 0);
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Clicod( 0 );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megcodigo( httpContext.getMessage( "DES2", "") );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megdescrip( httpContext.getMessage( "DESPIDO SIN CAUSA", "") );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Meghabilitado( true );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megres551( "12" );
      Gxm1motivoegreso = (web.SdtMotivoEgreso)new web.SdtMotivoEgreso( remoteHandle, context);
      Gxm2rootcol.add(Gxm1motivoegreso, 0);
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Clicod( 0 );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megcodigo( httpContext.getMessage( "FAL", "") );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megdescrip( httpContext.getMessage( "FALLECIMIENTO DEL EMPLEADO", "") );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Meghabilitado( true );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megres551( "00" );
      Gxm1motivoegreso = (web.SdtMotivoEgreso)new web.SdtMotivoEgreso( remoteHandle, context);
      Gxm2rootcol.add(Gxm1motivoegreso, 0);
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Clicod( 0 );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megcodigo( httpContext.getMessage( "JUB", "") );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megdescrip( httpContext.getMessage( "DESPIDO TRABAJADOR JUBILADO", "") );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Meghabilitado( true );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megres551( "12" );
      Gxm1motivoegreso = (web.SdtMotivoEgreso)new web.SdtMotivoEgreso( remoteHandle, context);
      Gxm2rootcol.add(Gxm1motivoegreso, 0);
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Clicod( 0 );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megcodigo( httpContext.getMessage( "REN", "") );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megdescrip( httpContext.getMessage( "RENUNCIA", "") );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Meghabilitado( true );
      Gxm1motivoegreso.setgxTv_SdtMotivoEgreso_Megres551( "12" );
      cleanup();
   }

   public static Object refClasses( )
   {
      GXutil.refClasses(motivoegreso_dataprovider.class);
      return new web.GXcfg();
   }

   protected void cleanup( )
   {
      this.aP0[0] = amotivoegreso_dataprovider.this.Gxm2rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm2rootcol = new GXBCCollection<web.SdtMotivoEgreso>(web.SdtMotivoEgreso.class, "MotivoEgreso", "PayDay", remoteHandle);
      Gxm1motivoegreso = new web.SdtMotivoEgreso(remoteHandle);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private GXBCCollection<web.SdtMotivoEgreso>[] aP0 ;
   private GXBCCollection<web.SdtMotivoEgreso> Gxm2rootcol ;
   private web.SdtMotivoEgreso Gxm1motivoegreso ;
}

