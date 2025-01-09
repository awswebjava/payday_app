package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class pasarganalicuotaatabla extends GXProcedure
{
   public pasarganalicuotaatabla( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( pasarganalicuotaatabla.class ), "" );
   }

   public pasarganalicuotaatabla( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( java.math.BigDecimal aP0 )
   {
      pasarganalicuotaatabla.this.aP1 = new byte[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( java.math.BigDecimal aP0 ,
                        byte[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( java.math.BigDecimal aP0 ,
                             byte[] aP1 )
   {
      pasarganalicuotaatabla.this.AV11porUnaje = aP0;
      pasarganalicuotaatabla.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( AV11porUnaje.doubleValue() == 0 )
      {
         AV10F1357_Alicuotas = (byte)(0) ;
      }
      else if ( DecimalUtil.compareTo(AV11porUnaje, DecimalUtil.stringToDec("0.05")) == 0 )
      {
         AV10F1357_Alicuotas = (byte)(1) ;
      }
      else if ( DecimalUtil.compareTo(AV11porUnaje, DecimalUtil.stringToDec("0.09")) == 0 )
      {
         AV10F1357_Alicuotas = (byte)(2) ;
      }
      else if ( DecimalUtil.compareTo(AV11porUnaje, DecimalUtil.stringToDec("0.12")) == 0 )
      {
         AV10F1357_Alicuotas = (byte)(3) ;
      }
      else if ( DecimalUtil.compareTo(AV11porUnaje, DecimalUtil.stringToDec("0.15")) == 0 )
      {
         AV10F1357_Alicuotas = (byte)(4) ;
      }
      else if ( DecimalUtil.compareTo(AV11porUnaje, DecimalUtil.stringToDec("0.19")) == 0 )
      {
         AV10F1357_Alicuotas = (byte)(5) ;
      }
      else if ( DecimalUtil.compareTo(AV11porUnaje, DecimalUtil.stringToDec("0.23")) == 0 )
      {
         AV10F1357_Alicuotas = (byte)(6) ;
      }
      else if ( DecimalUtil.compareTo(AV11porUnaje, DecimalUtil.stringToDec("0.27")) == 0 )
      {
         AV10F1357_Alicuotas = (byte)(7) ;
      }
      else if ( DecimalUtil.compareTo(AV11porUnaje, DecimalUtil.stringToDec("0.31")) == 0 )
      {
         AV10F1357_Alicuotas = (byte)(8) ;
      }
      else if ( DecimalUtil.compareTo(AV11porUnaje, DecimalUtil.stringToDec("0.35")) == 0 )
      {
         AV10F1357_Alicuotas = (byte)(9) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = pasarganalicuotaatabla.this.AV10F1357_Alicuotas;
      CloseOpenCursors();
      exitApp();
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

   private byte AV10F1357_Alicuotas ;
   private short Gx_err ;
   private java.math.BigDecimal AV11porUnaje ;
   private byte[] aP1 ;
}

