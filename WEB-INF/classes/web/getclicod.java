package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getclicod extends GXProcedure
{
   public getclicod( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getclicod.class ), "" );
   }

   public getclicod( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( )
   {
      getclicod.this.aP0 = new int[] {0};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( int[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( int[] aP0 )
   {
      getclicod.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8CliCod = (int)(GXutil.lval( AV9webSession.getValue(httpContext.getMessage( "CliCod", "")))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = getclicod.this.AV8CliCod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9webSession = httpContext.getWebSession();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private com.genexus.webpanels.WebSession AV9webSession ;
   private int[] aP0 ;
}

