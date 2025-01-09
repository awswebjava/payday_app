package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class eslocalhost extends GXProcedure
{
   public eslocalhost( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( eslocalhost.class ), "" );
   }

   public eslocalhost( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( )
   {
      eslocalhost.this.aP0 = new boolean[] {false};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( boolean[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( boolean[] aP0 )
   {
      eslocalhost.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ( GXutil.strSearch( AV8httpRequest.getServerHost(), "127", 1) != 0 ) || ( GXutil.strSearch( AV8httpRequest.getServerHost(), httpContext.getMessage( "localhost", ""), 1) != 0 ) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         AV9esLocalHost = true ;
      }
      else
      {
         AV9esLocalHost = false ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = eslocalhost.this.AV9esLocalHost;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8httpRequest = httpContext.getHttpRequest();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private boolean AV9esLocalHost ;
   private boolean Cond_result ;
   private com.genexus.internet.HttpRequest AV8httpRequest ;
   private boolean[] aP0 ;
}

