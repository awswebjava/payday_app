package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class excelhistorico extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(web.GXcfg.class);
      excelhistorico pgm = new excelhistorico (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {
      long aP0 = 0;

      try
      {
         aP0 = (long) GXutil.lval( args[0]);
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      execute(aP0);
   }

   public excelhistorico( )
   {
      super( -1 , new ModelContext( excelhistorico.class ), "" );
      Application.init(web.GXcfg.class);
   }

   public excelhistorico( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( excelhistorico.class ), "" );
   }

   public excelhistorico( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( long aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( long aP0 )
   {
      excelhistorico.this.AV2ImpSec = aP0;
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
   private long AV2ImpSec ;
}

