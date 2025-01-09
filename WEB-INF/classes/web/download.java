package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class download extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(web.GXcfg.class);
      download pgm = new download (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {
      String aP0 = "";
      String aP1 = "";
      String aP2 = "";

      try
      {
         aP0 = (String) args[0];
         aP1 = (String) args[1];
         aP2 = (String) args[2];
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      execute(aP0, aP1, aP2);
   }

   public download( )
   {
      super( -1 , new ModelContext( download.class ), "" );
      Application.init(web.GXcfg.class);
   }

   public download( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( download.class ), "" );
   }

   public download( int remoteHandle ,
                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 )
   {
      download.this.AV2contenttype = aP0;
      download.this.AV3filename = aP1;
      download.this.AV4filepath = aP2;
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
   private String AV2contenttype ;
   private String AV3filename ;
   private String AV4filepath ;
}

