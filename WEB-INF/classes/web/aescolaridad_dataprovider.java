package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.search.*;
import java.sql.*;

public final  class aescolaridad_dataprovider extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(web.GXcfg.class);
      aescolaridad_dataprovider pgm = new aescolaridad_dataprovider (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {
      @SuppressWarnings("unchecked")
      GXBCCollection<web.SdtEscolaridad>[] aP0 = new GXBCCollection[] {new GXBCCollection<web.SdtEscolaridad>()};

      try
      {
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      execute(aP0);
   }

   public aescolaridad_dataprovider( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( aescolaridad_dataprovider.class ), "" );
   }

   public aescolaridad_dataprovider( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBCCollection<web.SdtEscolaridad> executeUdp( )
   {
      aescolaridad_dataprovider.this.aP0 = new GXBCCollection[] {new GXBCCollection<web.SdtEscolaridad>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBCCollection<web.SdtEscolaridad>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBCCollection<web.SdtEscolaridad>[] aP0 )
   {
      aescolaridad_dataprovider.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      Gxm1escolaridad = (web.SdtEscolaridad)new web.SdtEscolaridad( remoteHandle, context);
      Gxm2rootcol.add(Gxm1escolaridad, 0);
      Gxm1escolaridad.setgxTv_SdtEscolaridad_Clicod( 0 );
      Gxm1escolaridad.setgxTv_SdtEscolaridad_Esccod( httpContext.getMessage( "INI", "") );
      Gxm1escolaridad.setgxTv_SdtEscolaridad_Escdescrip( httpContext.getMessage( "Inicial", "") );
      Gxm1escolaridad.setgxTv_SdtEscolaridad_Eschabilitada( true );
      Gxm1escolaridad.setgxTv_SdtEscolaridad_Escres551( "" );
      Gxm1escolaridad = (web.SdtEscolaridad)new web.SdtEscolaridad( remoteHandle, context);
      Gxm2rootcol.add(Gxm1escolaridad, 0);
      Gxm1escolaridad.setgxTv_SdtEscolaridad_Clicod( 0 );
      Gxm1escolaridad.setgxTv_SdtEscolaridad_Esccod( httpContext.getMessage( "PRI", "") );
      Gxm1escolaridad.setgxTv_SdtEscolaridad_Escdescrip( httpContext.getMessage( "Primaria", "") );
      Gxm1escolaridad.setgxTv_SdtEscolaridad_Eschabilitada( true );
      Gxm1escolaridad.setgxTv_SdtEscolaridad_Escres551( "" );
      Gxm1escolaridad = (web.SdtEscolaridad)new web.SdtEscolaridad( remoteHandle, context);
      Gxm2rootcol.add(Gxm1escolaridad, 0);
      Gxm1escolaridad.setgxTv_SdtEscolaridad_Clicod( 0 );
      Gxm1escolaridad.setgxTv_SdtEscolaridad_Esccod( httpContext.getMessage( "SEC", "") );
      Gxm1escolaridad.setgxTv_SdtEscolaridad_Escdescrip( httpContext.getMessage( "Secundaria", "") );
      Gxm1escolaridad.setgxTv_SdtEscolaridad_Eschabilitada( true );
      Gxm1escolaridad.setgxTv_SdtEscolaridad_Escres551( "" );
      Gxm1escolaridad = (web.SdtEscolaridad)new web.SdtEscolaridad( remoteHandle, context);
      Gxm2rootcol.add(Gxm1escolaridad, 0);
      Gxm1escolaridad.setgxTv_SdtEscolaridad_Clicod( 0 );
      Gxm1escolaridad.setgxTv_SdtEscolaridad_Esccod( httpContext.getMessage( "SUP", "") );
      Gxm1escolaridad.setgxTv_SdtEscolaridad_Escdescrip( httpContext.getMessage( "Superior", "") );
      Gxm1escolaridad.setgxTv_SdtEscolaridad_Eschabilitada( true );
      Gxm1escolaridad.setgxTv_SdtEscolaridad_Escres551( "" );
      cleanup();
   }

   public static Object refClasses( )
   {
      GXutil.refClasses(escolaridad_dataprovider.class);
      return new web.GXcfg();
   }

   protected void cleanup( )
   {
      this.aP0[0] = aescolaridad_dataprovider.this.Gxm2rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm2rootcol = new GXBCCollection<web.SdtEscolaridad>(web.SdtEscolaridad.class, "Escolaridad", "PayDay", remoteHandle);
      Gxm1escolaridad = new web.SdtEscolaridad(remoteHandle);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private GXBCCollection<web.SdtEscolaridad>[] aP0 ;
   private GXBCCollection<web.SdtEscolaridad> Gxm2rootcol ;
   private web.SdtEscolaridad Gxm1escolaridad ;
}

