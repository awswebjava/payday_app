package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class armatooltip extends GXProcedure
{
   public armatooltip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( armatooltip.class ), "" );
   }

   public armatooltip( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             java.math.BigDecimal aP1 ,
                             String aP2 ,
                             boolean aP3 )
   {
      armatooltip.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        java.math.BigDecimal aP1 ,
                        String aP2 ,
                        boolean aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             java.math.BigDecimal aP1 ,
                             String aP2 ,
                             boolean aP3 ,
                             String[] aP4 )
   {
      armatooltip.this.AV13CliCod = aP0;
      armatooltip.this.AV10Importes = aP1;
      armatooltip.this.AV8tooltip = aP2;
      armatooltip.this.AV11sacarDecimales = aP3;
      armatooltip.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( AV11sacarDecimales )
      {
         AV9valorStr = GXutil.trim( GXutil.str( GXutil.roundDecimal( AV10Importes, 0), 10, 0)) ;
      }
      else
      {
         AV9valorStr = GXutil.trim( GXutil.str( AV10Importes, 14, 2)) ;
      }
      if ( ! (GXutil.strcmp("", AV8tooltip)==0) )
      {
         AV12varchar = httpContext.getMessage( "<span title=\"", "") + GXutil.strReplace( GXutil.trim( AV8tooltip), "\"", "´´") + "\">" + GXutil.trim( AV9valorStr) + httpContext.getMessage( "</span>", "") ;
      }
      else
      {
         AV12varchar = GXutil.trim( AV9valorStr) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = armatooltip.this.AV12varchar;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12varchar = "" ;
      AV9valorStr = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV13CliCod ;
   private java.math.BigDecimal AV10Importes ;
   private boolean AV11sacarDecimales ;
   private String AV8tooltip ;
   private String AV12varchar ;
   private String AV9valorStr ;
   private String[] aP4 ;
}

