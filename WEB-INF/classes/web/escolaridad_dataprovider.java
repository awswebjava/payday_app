package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class escolaridad_dataprovider extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(web.GXcfg.class);
      escolaridad_dataprovider pgm = new escolaridad_dataprovider (-1);
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

   public escolaridad_dataprovider( )
   {
      super( -1 , new ModelContext( escolaridad_dataprovider.class ), "" );
      Application.init(web.GXcfg.class);
   }

   public escolaridad_dataprovider( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( escolaridad_dataprovider.class ), "" );
   }

   public escolaridad_dataprovider( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBCCollection<web.SdtEscolaridad> executeUdp( )
   {
      GXBCCollection<web.SdtEscolaridad>[] aP0 = new GXBCCollection[] {new GXBCCollection<web.SdtEscolaridad>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBCCollection<web.SdtEscolaridad>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBCCollection<web.SdtEscolaridad>[] aP0 )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      new web.aescolaridad_dataprovider(remoteHandle, context).execute( aP0 );
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

