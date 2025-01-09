package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class condicionafip_dataprovider extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(web.GXcfg.class);
      condicionafip_dataprovider pgm = new condicionafip_dataprovider (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {
      @SuppressWarnings("unchecked")
      GXBCCollection<web.SdtCondicionAFIP>[] aP0 = new GXBCCollection[] {new GXBCCollection<web.SdtCondicionAFIP>()};

      try
      {
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      execute(aP0);
   }

   public condicionafip_dataprovider( )
   {
      super( -1 , new ModelContext( condicionafip_dataprovider.class ), "" );
      Application.init(web.GXcfg.class);
   }

   public condicionafip_dataprovider( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( condicionafip_dataprovider.class ), "" );
   }

   public condicionafip_dataprovider( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBCCollection<web.SdtCondicionAFIP> executeUdp( )
   {
      GXBCCollection<web.SdtCondicionAFIP>[] aP0 = new GXBCCollection[] {new GXBCCollection<web.SdtCondicionAFIP>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBCCollection<web.SdtCondicionAFIP>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBCCollection<web.SdtCondicionAFIP>[] aP0 )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      new web.acondicionafip_dataprovider(remoteHandle, context).execute( aP0 );
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

