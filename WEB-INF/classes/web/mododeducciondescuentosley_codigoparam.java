package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class mododeducciondescuentosley_codigoparam extends GXProcedure
{
   public mododeducciondescuentosley_codigoparam( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( mododeducciondescuentosley_codigoparam.class ), "" );
   }

   public mododeducciondescuentosley_codigoparam( int remoteHandle ,
                                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      mododeducciondescuentosley_codigoparam.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      mododeducciondescuentosley_codigoparam.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8palabra = httpContext.getMessage( "MODO_DED_DESCU_LEY", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = mododeducciondescuentosley_codigoparam.this.AV8palabra;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8palabra = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8palabra ;
   private String[] aP0 ;
}

