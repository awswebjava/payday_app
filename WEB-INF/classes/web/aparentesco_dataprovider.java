package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.search.*;
import java.sql.*;

public final  class aparentesco_dataprovider extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(web.GXcfg.class);
      aparentesco_dataprovider pgm = new aparentesco_dataprovider (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {
      @SuppressWarnings("unchecked")
      GXBCCollection<web.SdtParentesco>[] aP0 = new GXBCCollection[] {new GXBCCollection<web.SdtParentesco>()};

      try
      {
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      execute(aP0);
   }

   public aparentesco_dataprovider( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( aparentesco_dataprovider.class ), "" );
   }

   public aparentesco_dataprovider( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBCCollection<web.SdtParentesco> executeUdp( )
   {
      aparentesco_dataprovider.this.aP0 = new GXBCCollection[] {new GXBCCollection<web.SdtParentesco>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBCCollection<web.SdtParentesco>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBCCollection<web.SdtParentesco>[] aP0 )
   {
      aparentesco_dataprovider.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      Gxm1parentesco = (web.SdtParentesco)new web.SdtParentesco( remoteHandle, context);
      Gxm2rootcol.add(Gxm1parentesco, 0);
      Gxm1parentesco.setgxTv_SdtParentesco_Clicod( 0 );
      Gxm1parentesco.setgxTv_SdtParentesco_Parcod( "1" );
      Gxm1parentesco.setgxTv_SdtParentesco_Pardescrip( httpContext.getMessage( "CONYUGE", "") );
      Gxm1parentesco.setgxTv_SdtParentesco_Pardescripsinac( httpContext.getMessage( "CONYUGE", "") );
      Gxm1parentesco.setgxTv_SdtParentesco_Parres551( "" );
      Gxm1parentesco.setgxTv_SdtParentesco_Parhabilitado( true );
      Gxm1parentesco.setgxTv_SdtParentesco_Parentipo( "1" );
      Gxm1parentesco = (web.SdtParentesco)new web.SdtParentesco( remoteHandle, context);
      Gxm2rootcol.add(Gxm1parentesco, 0);
      Gxm1parentesco.setgxTv_SdtParentesco_Clicod( 0 );
      Gxm1parentesco.setgxTv_SdtParentesco_Parcod( "2" );
      Gxm1parentesco.setgxTv_SdtParentesco_Pardescrip( httpContext.getMessage( "HIJO/HIJA", "") );
      Gxm1parentesco.setgxTv_SdtParentesco_Pardescripsinac( httpContext.getMessage( "HIJO/HIJA", "") );
      Gxm1parentesco.setgxTv_SdtParentesco_Parres551( "" );
      Gxm1parentesco.setgxTv_SdtParentesco_Parhabilitado( true );
      Gxm1parentesco.setgxTv_SdtParentesco_Parentipo( "2" );
      cleanup();
   }

   public static Object refClasses( )
   {
      GXutil.refClasses(parentesco_dataprovider.class);
      return new web.GXcfg();
   }

   protected void cleanup( )
   {
      this.aP0[0] = aparentesco_dataprovider.this.Gxm2rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm2rootcol = new GXBCCollection<web.SdtParentesco>(web.SdtParentesco.class, "Parentesco", "PayDay", remoteHandle);
      Gxm1parentesco = new web.SdtParentesco(remoteHandle);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private GXBCCollection<web.SdtParentesco>[] aP0 ;
   private GXBCCollection<web.SdtParentesco> Gxm2rootcol ;
   private web.SdtParentesco Gxm1parentesco ;
}

