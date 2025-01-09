package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class legvalidaregreso extends GXProcedure
{
   public legvalidaregreso( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legvalidaregreso.class ), "" );
   }

   public legvalidaregreso( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 ,
                                     short aP1 ,
                                     int aP2 ,
                                     java.util.Date aP3 ,
                                     boolean[] aP4 )
   {
      legvalidaregreso.this.aP5 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        boolean[] aP4 ,
                        java.util.Date[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             boolean[] aP4 ,
                             java.util.Date[] aP5 )
   {
      legvalidaregreso.this.AV13CliCod = aP0;
      legvalidaregreso.this.AV12EmpCod = aP1;
      legvalidaregreso.this.AV10LegNumero = aP2;
      legvalidaregreso.this.AV8LegFecEgreso = aP3;
      legvalidaregreso.this.aP4 = aP4;
      legvalidaregreso.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_date1[0] = AV11ultiLiqPeriodo ;
      GXv_char2[0] = AV14ultiTLiqCod ;
      new web.ultimoperiodoliquidado(remoteHandle, context).execute( AV13CliCod, AV12EmpCod, AV10LegNumero, GXv_date1, GXv_char2) ;
      legvalidaregreso.this.AV11ultiLiqPeriodo = GXv_date1[0] ;
      legvalidaregreso.this.AV14ultiTLiqCod = GXv_char2[0] ;
      GXt_char3 = AV15mesTLiqCod ;
      GXt_char4 = AV15mesTLiqCod ;
      GXv_char2[0] = GXt_char4 ;
      new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char2) ;
      legvalidaregreso.this.GXt_char4 = GXv_char2[0] ;
      GXv_char5[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV13CliCod, GXt_char4, GXv_char5) ;
      legvalidaregreso.this.GXt_char3 = GXv_char5[0] ;
      AV15mesTLiqCod = GXt_char3 ;
      if ( GXutil.strcmp(AV14ultiTLiqCod, AV15mesTLiqCod) == 0 )
      {
         AV9ultimoDiaLiquidacion = GXutil.eomdate( AV11ultiLiqPeriodo) ;
      }
      else
      {
         GXv_date1[0] = AV16date ;
         GXv_date6[0] = AV9ultimoDiaLiquidacion ;
         new web.getperiodoquincena(remoteHandle, context).execute( AV13CliCod, (short)(1), AV11ultiLiqPeriodo, GXv_date1, GXv_date6) ;
         legvalidaregreso.this.AV16date = GXv_date1[0] ;
         legvalidaregreso.this.AV9ultimoDiaLiquidacion = GXv_date6[0] ;
      }
      if ( GXutil.resetTime(AV8LegFecEgreso).before( GXutil.resetTime( AV9ultimoDiaLiquidacion )) )
      {
         AV19ok = false ;
      }
      else
      {
         AV19ok = true ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = legvalidaregreso.this.AV19ok;
      this.aP5[0] = legvalidaregreso.this.AV9ultimoDiaLiquidacion;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9ultimoDiaLiquidacion = GXutil.nullDate() ;
      AV11ultiLiqPeriodo = GXutil.nullDate() ;
      AV14ultiTLiqCod = "" ;
      AV15mesTLiqCod = "" ;
      GXt_char3 = "" ;
      GXt_char4 = "" ;
      GXv_char2 = new String[1] ;
      GXv_char5 = new String[1] ;
      AV16date = GXutil.nullDate() ;
      GXv_date1 = new java.util.Date[1] ;
      GXv_date6 = new java.util.Date[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12EmpCod ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV10LegNumero ;
   private String AV14ultiTLiqCod ;
   private String AV15mesTLiqCod ;
   private String GXt_char3 ;
   private String GXt_char4 ;
   private String GXv_char2[] ;
   private String GXv_char5[] ;
   private java.util.Date AV8LegFecEgreso ;
   private java.util.Date AV9ultimoDiaLiquidacion ;
   private java.util.Date AV11ultiLiqPeriodo ;
   private java.util.Date AV16date ;
   private java.util.Date GXv_date1[] ;
   private java.util.Date GXv_date6[] ;
   private boolean AV19ok ;
   private java.util.Date[] aP5 ;
   private boolean[] aP4 ;
}

