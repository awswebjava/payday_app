package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class secrolewwexportreport extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(web.GXcfg.class);
      secrolewwexportreport pgm = new secrolewwexportreport (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {

      execute();
   }

   public secrolewwexportreport( )
   {
      super( -1 , new ModelContext( secrolewwexportreport.class ), "" );
      Application.init(web.GXcfg.class);
   }

   public secrolewwexportreport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secrolewwexportreport.class ), "" );
   }

   public secrolewwexportreport( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( )
   {
      execute_int();
   }

   private void execute_int( )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
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

