package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.search.*;
import java.sql.*;

public final  class atipoliquidacion_dataprovider extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(web.GXcfg.class);
      atipoliquidacion_dataprovider pgm = new atipoliquidacion_dataprovider (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {
      @SuppressWarnings("unchecked")
      GXBCCollection<web.SdtTipoLiquidacion>[] aP0 = new GXBCCollection[] {new GXBCCollection<web.SdtTipoLiquidacion>()};

      try
      {
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      execute(aP0);
   }

   public atipoliquidacion_dataprovider( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( atipoliquidacion_dataprovider.class ), "" );
   }

   public atipoliquidacion_dataprovider( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBCCollection<web.SdtTipoLiquidacion> executeUdp( )
   {
      atipoliquidacion_dataprovider.this.aP0 = new GXBCCollection[] {new GXBCCollection<web.SdtTipoLiquidacion>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBCCollection<web.SdtTipoLiquidacion>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBCCollection<web.SdtTipoLiquidacion>[] aP0 )
   {
      atipoliquidacion_dataprovider.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      Gxm1tipoliquidacion = (web.SdtTipoLiquidacion)new web.SdtTipoLiquidacion( remoteHandle, context);
      Gxm2rootcol.add(Gxm1tipoliquidacion, 0);
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Clicod( 0 );
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new web.codigoaguinaldo(remoteHandle, context).execute( GXv_char2) ;
      atipoliquidacion_dataprovider.this.GXt_char1 = GXv_char2[0] ;
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqcod( GXt_char1 );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqdesc( httpContext.getMessage( "AGUINALDO", "") );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqhabilitada( true );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqacudiastrab( false );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqsac( true );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqord( (short)(4) );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqcodfor( httpContext.getMessage( "sac", "") );
      Gxm1tipoliquidacion = (web.SdtTipoLiquidacion)new web.SdtTipoLiquidacion( remoteHandle, context);
      Gxm2rootcol.add(Gxm1tipoliquidacion, 0);
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Clicod( 0 );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqcod( httpContext.getMessage( "EGRESO", "") );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqdesc( httpContext.getMessage( "EGRESO", "") );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqhabilitada( true );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqacudiastrab( true );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqsac( true );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqord( (short)(7) );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqcodfor( httpContext.getMessage( "egreso", "") );
      Gxm1tipoliquidacion = (web.SdtTipoLiquidacion)new web.SdtTipoLiquidacion( remoteHandle, context);
      Gxm2rootcol.add(Gxm1tipoliquidacion, 0);
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Clicod( 0 );
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new web.codigomensual(remoteHandle, context).execute( GXv_char2) ;
      atipoliquidacion_dataprovider.this.GXt_char1 = GXv_char2[0] ;
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqcod( GXt_char1 );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqdesc( httpContext.getMessage( "SEG. QUINCENA O MES", "") );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqhabilitada( true );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqacudiastrab( true );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqsac( true );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqord( (short)(2) );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqcodfor( httpContext.getMessage( "mes", "") );
      Gxm1tipoliquidacion = (web.SdtTipoLiquidacion)new web.SdtTipoLiquidacion( remoteHandle, context);
      Gxm2rootcol.add(Gxm1tipoliquidacion, 0);
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Clicod( 0 );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqcod( httpContext.getMessage( "QUINCENA_1", "") );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqdesc( httpContext.getMessage( "PRIMERA QUINCENA", "") );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqhabilitada( true );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqacudiastrab( true );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqsac( false );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqord( (short)(1) );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqcodfor( httpContext.getMessage( "primera_quincena", "") );
      Gxm1tipoliquidacion = (web.SdtTipoLiquidacion)new web.SdtTipoLiquidacion( remoteHandle, context);
      Gxm2rootcol.add(Gxm1tipoliquidacion, 0);
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Clicod( 0 );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqcod( httpContext.getMessage( "VACACIONES", "") );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqdesc( httpContext.getMessage( "ADELANTO DE VACACIONES", "") );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqhabilitada( true );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqacudiastrab( true );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqsac( false );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqord( (short)(3) );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqcodfor( httpContext.getMessage( "vacaciones", "") );
      Gxm1tipoliquidacion = (web.SdtTipoLiquidacion)new web.SdtTipoLiquidacion( remoteHandle, context);
      Gxm2rootcol.add(Gxm1tipoliquidacion, 0);
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Clicod( 0 );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqcod( httpContext.getMessage( "ANTICIPO", "") );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqdesc( httpContext.getMessage( "ANTICIPO DE SUELDO", "") );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqhabilitada( true );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqacudiastrab( false );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqsac( false );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqord( (short)(6) );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqcodfor( httpContext.getMessage( "anticipo", "") );
      Gxm1tipoliquidacion = (web.SdtTipoLiquidacion)new web.SdtTipoLiquidacion( remoteHandle, context);
      Gxm2rootcol.add(Gxm1tipoliquidacion, 0);
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Clicod( 0 );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqcod( httpContext.getMessage( "VARIOS", "") );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqdesc( httpContext.getMessage( "VARIOS", "") );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqhabilitada( false );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqacudiastrab( false );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqsac( false );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqord( (short)(5) );
      Gxm1tipoliquidacion.setgxTv_SdtTipoLiquidacion_Tliqcodfor( httpContext.getMessage( "varios", "") );
      cleanup();
   }

   public static Object refClasses( )
   {
      GXutil.refClasses(tipoliquidacion_dataprovider.class);
      return new web.GXcfg();
   }

   protected void cleanup( )
   {
      this.aP0[0] = atipoliquidacion_dataprovider.this.Gxm2rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm2rootcol = new GXBCCollection<web.SdtTipoLiquidacion>(web.SdtTipoLiquidacion.class, "TipoLiquidacion", "PayDay", remoteHandle);
      Gxm1tipoliquidacion = new web.SdtTipoLiquidacion(remoteHandle);
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private GXBCCollection<web.SdtTipoLiquidacion>[] aP0 ;
   private GXBCCollection<web.SdtTipoLiquidacion> Gxm2rootcol ;
   private web.SdtTipoLiquidacion Gxm1tipoliquidacion ;
}

