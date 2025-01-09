package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class tipoliquidacion_dataprovider extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(web.GXcfg.class);
      tipoliquidacion_dataprovider pgm = new tipoliquidacion_dataprovider (-1);
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

   public tipoliquidacion_dataprovider( )
   {
      super( -1 , new ModelContext( tipoliquidacion_dataprovider.class ), "" );
      Application.init(web.GXcfg.class);
   }

   public tipoliquidacion_dataprovider( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tipoliquidacion_dataprovider.class ), "" );
   }

   public tipoliquidacion_dataprovider( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBCCollection<web.SdtTipoLiquidacion> executeUdp( )
   {
      GXBCCollection<web.SdtTipoLiquidacion>[] aP0 = new GXBCCollection[] {new GXBCCollection<web.SdtTipoLiquidacion>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBCCollection<web.SdtTipoLiquidacion>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBCCollection<web.SdtTipoLiquidacion>[] aP0 )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      new web.atipoliquidacion_dataprovider(remoteHandle, context).execute( aP0 );
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      Application.cleanup(context, this, remoteHandle);
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
}

