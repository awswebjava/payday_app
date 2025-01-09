package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class lambda_calcliqtodo extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(web.GXcfg.class);
      lambda_calcliqtodo pgm = new lambda_calcliqtodo (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {
      String aP0 = "";
      com.genexus.genexusserverlessapi.SdtEventMessageResponse[] aP1 = new com.genexus.genexusserverlessapi.SdtEventMessageResponse[] {new com.genexus.genexusserverlessapi.SdtEventMessageResponse()};

      try
      {
         aP0 = (String) args[0];
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      execute(aP0, aP1);
   }

   public lambda_calcliqtodo( )
   {
      super( -1 , new ModelContext( lambda_calcliqtodo.class ), "" );
      Application.init(web.GXcfg.class);
   }

   public lambda_calcliqtodo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( lambda_calcliqtodo.class ), "" );
   }

   public lambda_calcliqtodo( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public com.genexus.genexusserverlessapi.SdtEventMessageResponse executeUdp( String aP0 )
   {
      com.genexus.genexusserverlessapi.SdtEventMessageResponse[] aP1 = new com.genexus.genexusserverlessapi.SdtEventMessageResponse[] {new com.genexus.genexusserverlessapi.SdtEventMessageResponse()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        com.genexus.genexusserverlessapi.SdtEventMessageResponse[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             com.genexus.genexusserverlessapi.SdtEventMessageResponse[] aP1 )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      new web.alambda_calcliqtodo(remoteHandle, context).execute( aP0, aP1 );
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

