package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class definecantiyunimed extends GXProcedure
{
   public definecantiyunimed( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( definecantiyunimed.class ), "" );
   }

   public definecantiyunimed( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( java.math.BigDecimal aP0 ,
                             byte aP1 ,
                             java.math.BigDecimal aP2 ,
                             java.math.BigDecimal[] aP3 )
   {
      definecantiyunimed.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( java.math.BigDecimal aP0 ,
                        byte aP1 ,
                        java.math.BigDecimal aP2 ,
                        java.math.BigDecimal[] aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( java.math.BigDecimal aP0 ,
                             byte aP1 ,
                             java.math.BigDecimal aP2 ,
                             java.math.BigDecimal[] aP3 ,
                             String[] aP4 )
   {
      definecantiyunimed.this.AV8ConOpeEsCant = aP0;
      definecantiyunimed.this.AV9LiqDCalculado = aP1;
      definecantiyunimed.this.AV12cantidadCalculada = aP2;
      definecantiyunimed.this.aP3 = aP3;
      definecantiyunimed.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV8ConOpeEsCant)==0) )
      {
         if ( AV9LiqDCalculado == 1 )
         {
            AV10LiqDCanti = AV8ConOpeEsCant ;
         }
         if ( AV13OpeCliAliEs )
         {
            AV11LiqDUniMed = "%" ;
         }
      }
      else
      {
         if ( AV9LiqDCalculado == 1 )
         {
            AV10LiqDCanti = AV12cantidadCalculada ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = definecantiyunimed.this.AV10LiqDCanti;
      this.aP4[0] = definecantiyunimed.this.AV11LiqDUniMed;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10LiqDCanti = DecimalUtil.ZERO ;
      AV11LiqDUniMed = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV9LiqDCalculado ;
   private short Gx_err ;
   private java.math.BigDecimal AV8ConOpeEsCant ;
   private java.math.BigDecimal AV12cantidadCalculada ;
   private java.math.BigDecimal AV10LiqDCanti ;
   private String AV11LiqDUniMed ;
   private boolean AV13OpeCliAliEs ;
   private String[] aP4 ;
   private java.math.BigDecimal[] aP3 ;
}

