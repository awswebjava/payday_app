package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obtenerdesesionnumerico extends GXProcedure
{
   public obtenerdesesionnumerico( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obtenerdesesionnumerico.class ), "" );
   }

   public obtenerdesesionnumerico( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( String aP0 )
   {
      obtenerdesesionnumerico.this.aP1 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        java.math.BigDecimal[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             java.math.BigDecimal[] aP1 )
   {
      obtenerdesesionnumerico.this.AV8key = aP0;
      obtenerdesesionnumerico.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9value = CommonUtil.decimalVal( AV10websession.getValue(AV8key), ".") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = obtenerdesesionnumerico.this.AV9value;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9value = DecimalUtil.ZERO ;
      AV10websession = httpContext.getWebSession();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private java.math.BigDecimal AV9value ;
   private String AV8key ;
   private com.genexus.webpanels.WebSession AV10websession ;
   private java.math.BigDecimal[] aP1 ;
}

