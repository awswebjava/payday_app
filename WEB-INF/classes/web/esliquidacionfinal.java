package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class esliquidacionfinal extends GXProcedure
{
   public esliquidacionfinal( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( esliquidacionfinal.class ), "" );
   }

   public esliquidacionfinal( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              java.util.Date aP3 )
   {
      esliquidacionfinal.this.aP4 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        boolean[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             boolean[] aP4 )
   {
      esliquidacionfinal.this.AV12CliCod = aP0;
      esliquidacionfinal.this.AV14EmpCod = aP1;
      esliquidacionfinal.this.AV15LiqNro = aP2;
      esliquidacionfinal.this.AV8LiqPeriodo = aP3;
      esliquidacionfinal.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV10TLiqCod ;
      new web.gettipoliq(remoteHandle, context).execute( AV12CliCod, AV14EmpCod, AV15LiqNro, GXv_char1) ;
      esliquidacionfinal.this.AV10TLiqCod = GXv_char1[0] ;
      GXt_char2 = AV9finalTLiqCod ;
      GXt_char3 = AV9finalTLiqCod ;
      GXv_char1[0] = GXt_char3 ;
      new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char1) ;
      esliquidacionfinal.this.GXt_char3 = GXv_char1[0] ;
      GXv_char4[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV12CliCod, GXt_char3, GXv_char4) ;
      esliquidacionfinal.this.GXt_char2 = GXv_char4[0] ;
      AV9finalTLiqCod = GXt_char2 ;
      if ( ( GXutil.month( AV8LiqPeriodo) == 12 ) || ( GXutil.strcmp(AV10TLiqCod, AV9finalTLiqCod) == 0 ) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         AV13finalEs = true ;
      }
      else
      {
         AV13finalEs = false ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = esliquidacionfinal.this.AV13finalEs;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10TLiqCod = "" ;
      AV9finalTLiqCod = "" ;
      GXt_char2 = "" ;
      GXt_char3 = "" ;
      GXv_char1 = new String[1] ;
      GXv_char4 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV14EmpCod ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV15LiqNro ;
   private String AV10TLiqCod ;
   private String AV9finalTLiqCod ;
   private String GXt_char2 ;
   private String GXt_char3 ;
   private String GXv_char1[] ;
   private String GXv_char4[] ;
   private java.util.Date AV8LiqPeriodo ;
   private boolean AV13finalEs ;
   private boolean Cond_result ;
   private boolean[] aP4 ;
}

