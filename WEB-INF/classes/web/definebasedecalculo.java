package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class definebasedecalculo extends GXProcedure
{
   public definebasedecalculo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( definebasedecalculo.class ), "" );
   }

   public definebasedecalculo( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( java.math.BigDecimal aP0 ,
                                           java.math.BigDecimal aP1 ,
                                           String aP2 )
   {
      definebasedecalculo.this.aP3 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( java.math.BigDecimal aP0 ,
                        java.math.BigDecimal aP1 ,
                        String aP2 ,
                        java.math.BigDecimal[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( java.math.BigDecimal aP0 ,
                             java.math.BigDecimal aP1 ,
                             String aP2 ,
                             java.math.BigDecimal[] aP3 )
   {
      definebasedecalculo.this.AV8LiqDImpCalcu = aP0;
      definebasedecalculo.this.AV9LiqDCanti = aP1;
      definebasedecalculo.this.AV11LiqDUniMed = aP2;
      definebasedecalculo.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10BaseImportes = AV8LiqDImpCalcu ;
      if ( AV9LiqDCanti.doubleValue() > 0 )
      {
         AV10BaseImportes = AV10BaseImportes.divide(AV9LiqDCanti, 18, java.math.RoundingMode.DOWN) ;
         if ( GXutil.strcmp(AV11LiqDUniMed, "%") == 0 )
         {
            AV10BaseImportes = AV10BaseImportes.multiply(DecimalUtil.doubleToDec(100)) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = definebasedecalculo.this.AV10BaseImportes;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10BaseImportes = DecimalUtil.ZERO ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private java.math.BigDecimal AV8LiqDImpCalcu ;
   private java.math.BigDecimal AV9LiqDCanti ;
   private java.math.BigDecimal AV10BaseImportes ;
   private String AV11LiqDUniMed ;
   private java.math.BigDecimal[] aP3 ;
}

