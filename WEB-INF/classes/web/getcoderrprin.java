package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getcoderrprin extends GXProcedure
{
   public getcoderrprin( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getcoderrprin.class ), "" );
   }

   public getcoderrprin( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      getcoderrprin.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      getcoderrprin.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8error_palabra = httpContext.getMessage( "<span style=\"display: none;\">{ERROR_PRICIPAL}</span>", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = getcoderrprin.this.AV8error_palabra;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8error_palabra = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8error_palabra ;
   private String[] aP0 ;
}

