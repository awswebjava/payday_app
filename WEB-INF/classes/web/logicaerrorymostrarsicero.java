package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class logicaerrorymostrarsicero extends GXProcedure
{
   public logicaerrorymostrarsicero( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( logicaerrorymostrarsicero.class ), "" );
   }

   public logicaerrorymostrarsicero( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( java.math.BigDecimal aP0 ,
                           boolean aP1 ,
                           boolean aP2 ,
                           String aP3 ,
                           String aP4 ,
                           byte aP5 ,
                           java.math.BigDecimal aP6 ,
                           String[] aP7 ,
                           boolean[] aP8 ,
                           boolean[] aP9 )
   {
      logicaerrorymostrarsicero.this.aP10 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( java.math.BigDecimal aP0 ,
                        boolean aP1 ,
                        boolean aP2 ,
                        String aP3 ,
                        String aP4 ,
                        byte aP5 ,
                        java.math.BigDecimal aP6 ,
                        String[] aP7 ,
                        boolean[] aP8 ,
                        boolean[] aP9 ,
                        byte[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( java.math.BigDecimal aP0 ,
                             boolean aP1 ,
                             boolean aP2 ,
                             String aP3 ,
                             String aP4 ,
                             byte aP5 ,
                             java.math.BigDecimal aP6 ,
                             String[] aP7 ,
                             boolean[] aP8 ,
                             boolean[] aP9 ,
                             byte[] aP10 )
   {
      logicaerrorymostrarsicero.this.AV12LiqDImpCalcu = aP0;
      logicaerrorymostrarsicero.this.AV8ConMostrarPos = aP1;
      logicaerrorymostrarsicero.this.AV19ConErrorSiCero = aP2;
      logicaerrorymostrarsicero.this.AV9DConCodigo = aP3;
      logicaerrorymostrarsicero.this.AV13sueldoConCodigo = aP4;
      logicaerrorymostrarsicero.this.AV10EmpTipoExp = aP5;
      logicaerrorymostrarsicero.this.AV14cantidadCalculada = aP6;
      logicaerrorymostrarsicero.this.aP7 = aP7;
      logicaerrorymostrarsicero.this.aP8 = aP8;
      logicaerrorymostrarsicero.this.aP9 = aP9;
      logicaerrorymostrarsicero.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ( ( AV12LiqDImpCalcu.doubleValue() > 0 ) && ( AV8ConMostrarPos ) ) || ! AV8ConMostrarPos )
      {
         AV11errorPorCero = false ;
         if ( AV19ConErrorSiCero )
         {
            if ( AV12LiqDImpCalcu.doubleValue() == 0 )
            {
               if ( GXutil.strcmp(AV9DConCodigo, AV13sueldoConCodigo) != 0 )
               {
                  AV11errorPorCero = true ;
               }
               else
               {
                  if ( ( AV10EmpTipoExp == ( 0 )) )
                  {
                     AV11errorPorCero = true ;
                  }
                  else
                  {
                     if ( AV14cantidadCalculada.doubleValue() > 0 )
                     {
                        AV11errorPorCero = true ;
                     }
                  }
               }
            }
         }
         if ( AV11errorPorCero )
         {
            AV15LiqDErrorDesc = httpContext.getMessage( "Concepto calculado en cero", "") ;
            AV16calculoCero = true ;
            AV17errorComunHay = true ;
         }
         if ( AV12LiqDImpCalcu.doubleValue() != 0 )
         {
            AV18LiqDMostrar = (byte)(3) ;
         }
         else
         {
            AV18LiqDMostrar = (byte)(0) ;
         }
      }
      else
      {
         if ( AV12LiqDImpCalcu.doubleValue() > 0 )
         {
            AV18LiqDMostrar = (byte)(2) ;
         }
         else
         {
            AV18LiqDMostrar = (byte)(0) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = logicaerrorymostrarsicero.this.AV15LiqDErrorDesc;
      this.aP8[0] = logicaerrorymostrarsicero.this.AV16calculoCero;
      this.aP9[0] = logicaerrorymostrarsicero.this.AV17errorComunHay;
      this.aP10[0] = logicaerrorymostrarsicero.this.AV18LiqDMostrar;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15LiqDErrorDesc = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV10EmpTipoExp ;
   private byte AV18LiqDMostrar ;
   private short Gx_err ;
   private java.math.BigDecimal AV12LiqDImpCalcu ;
   private java.math.BigDecimal AV14cantidadCalculada ;
   private String AV9DConCodigo ;
   private String AV13sueldoConCodigo ;
   private boolean AV8ConMostrarPos ;
   private boolean AV19ConErrorSiCero ;
   private boolean AV16calculoCero ;
   private boolean AV17errorComunHay ;
   private boolean AV11errorPorCero ;
   private String AV15LiqDErrorDesc ;
   private byte[] aP10 ;
   private String[] aP7 ;
   private boolean[] aP8 ;
   private boolean[] aP9 ;
}

