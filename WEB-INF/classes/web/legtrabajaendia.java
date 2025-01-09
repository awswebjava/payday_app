package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class legtrabajaendia extends GXProcedure
{
   public legtrabajaendia( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legtrabajaendia.class ), "" );
   }

   public legtrabajaendia( int remoteHandle ,
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
      legtrabajaendia.this.aP4 = new boolean[] {false};
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
      legtrabajaendia.this.AV8CliCod = aP0;
      legtrabajaendia.this.AV9EmpCod = aP1;
      legtrabajaendia.this.AV10LegNumero = aP2;
      legtrabajaendia.this.AV18fecha = aP3;
      legtrabajaendia.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_boolean1[0] = AV11LegTrabDo ;
      GXv_boolean2[0] = AV12LegTrabLun ;
      GXv_boolean3[0] = AV13LegTrabMar ;
      GXv_boolean4[0] = AV14LegTrabMie ;
      GXv_boolean5[0] = AV15LegTrabJue ;
      GXv_boolean6[0] = AV16LegTrabVie ;
      GXv_boolean7[0] = AV17LegTrabSa ;
      new web.legdiastrabaja(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LegNumero, GXv_boolean1, GXv_boolean2, GXv_boolean3, GXv_boolean4, GXv_boolean5, GXv_boolean6, GXv_boolean7) ;
      legtrabajaendia.this.AV11LegTrabDo = GXv_boolean1[0] ;
      legtrabajaendia.this.AV12LegTrabLun = GXv_boolean2[0] ;
      legtrabajaendia.this.AV13LegTrabMar = GXv_boolean3[0] ;
      legtrabajaendia.this.AV14LegTrabMie = GXv_boolean4[0] ;
      legtrabajaendia.this.AV15LegTrabJue = GXv_boolean5[0] ;
      legtrabajaendia.this.AV16LegTrabVie = GXv_boolean6[0] ;
      legtrabajaendia.this.AV17LegTrabSa = GXv_boolean7[0] ;
      if ( GXutil.dow( AV18fecha) == 1 )
      {
         AV19trabaja = AV11LegTrabDo ;
      }
      else if ( GXutil.dow( AV18fecha) == 2 )
      {
         AV19trabaja = AV12LegTrabLun ;
      }
      else if ( GXutil.dow( AV18fecha) == 3 )
      {
         AV19trabaja = AV13LegTrabMar ;
      }
      else if ( GXutil.dow( AV18fecha) == 4 )
      {
         AV19trabaja = AV14LegTrabMie ;
      }
      else if ( GXutil.dow( AV18fecha) == 5 )
      {
         AV19trabaja = AV15LegTrabJue ;
      }
      else if ( GXutil.dow( AV18fecha) == 6 )
      {
         AV19trabaja = AV16LegTrabVie ;
      }
      else if ( GXutil.dow( AV18fecha) == 7 )
      {
         AV19trabaja = AV17LegTrabSa ;
      }
      if ( AV19trabaja )
      {
         GXv_int8[0] = AV21PaiCod ;
         new web.clientegetpais(remoteHandle, context).execute( AV8CliCod, GXv_int8) ;
         legtrabajaendia.this.AV21PaiCod = GXv_int8[0] ;
         GXv_boolean7[0] = AV20feriadoEs ;
         new web.diaesferiado(remoteHandle, context).execute( AV21PaiCod, AV18fecha, GXv_boolean7) ;
         legtrabajaendia.this.AV20feriadoEs = GXv_boolean7[0] ;
         if ( AV20feriadoEs )
         {
            AV19trabaja = false ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = legtrabajaendia.this.AV19trabaja;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_boolean1 = new boolean[1] ;
      GXv_boolean2 = new boolean[1] ;
      GXv_boolean3 = new boolean[1] ;
      GXv_boolean4 = new boolean[1] ;
      GXv_boolean5 = new boolean[1] ;
      GXv_boolean6 = new boolean[1] ;
      GXv_int8 = new short[1] ;
      GXv_boolean7 = new boolean[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short AV21PaiCod ;
   private short GXv_int8[] ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LegNumero ;
   private java.util.Date AV18fecha ;
   private boolean AV19trabaja ;
   private boolean AV11LegTrabDo ;
   private boolean GXv_boolean1[] ;
   private boolean AV12LegTrabLun ;
   private boolean GXv_boolean2[] ;
   private boolean AV13LegTrabMar ;
   private boolean GXv_boolean3[] ;
   private boolean AV14LegTrabMie ;
   private boolean GXv_boolean4[] ;
   private boolean AV15LegTrabJue ;
   private boolean GXv_boolean5[] ;
   private boolean AV16LegTrabVie ;
   private boolean GXv_boolean6[] ;
   private boolean AV17LegTrabSa ;
   private boolean AV20feriadoEs ;
   private boolean GXv_boolean7[] ;
   private boolean[] aP4 ;
}

