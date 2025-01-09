package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class importarlegajosseleccionados extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(web.GXcfg.class);
      importarlegajosseleccionados pgm = new importarlegajosseleccionados (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {
      @SuppressWarnings("unchecked")
      GXBaseCollection<web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem>[] aP0 = new GXBaseCollection[] {new GXBaseCollection<web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem>()};

      try
      {
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      execute(aP0);
   }

   public importarlegajosseleccionados( )
   {
      super( -1 , new ModelContext( importarlegajosseleccionados.class ), "" );
      Application.init(web.GXcfg.class);
   }

   public importarlegajosseleccionados( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importarlegajosseleccionados.class ), "" );
   }

   public importarlegajosseleccionados( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem> executeUdp( )
   {
      GXBaseCollection<web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem>[] aP0 = new GXBaseCollection[] {new GXBaseCollection<web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<web.Sdtimportacion_legajoWWSDT_importacion_legajoWWSDTItem>[] aP0 )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      new web.aimportarlegajosseleccionados(remoteHandle, context).execute( aP0 );
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

