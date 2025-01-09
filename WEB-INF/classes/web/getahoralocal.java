package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getahoralocal extends GXProcedure
{
   public getahoralocal( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getahoralocal.class ), "" );
   }

   public getahoralocal( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 )
   {
      getahoralocal.this.aP1 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        java.util.Date[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             java.util.Date[] aP1 )
   {
      getahoralocal.this.AV9clicod = aP0;
      getahoralocal.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10utcAhora = GXutil.nowms( ) ;
      AV8ahora = GXutil.dtadd( AV10utcAhora, 3600*(-3)) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getahoralocal.this.AV8ahora;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8ahora = GXutil.resetTime( GXutil.nullDate() );
      AV10utcAhora = GXutil.resetTime( GXutil.nullDate() );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9clicod ;
   private java.util.Date AV8ahora ;
   private java.util.Date AV10utcAhora ;
   private java.util.Date[] aP1 ;
}

