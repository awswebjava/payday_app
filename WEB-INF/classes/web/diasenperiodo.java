package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class diasenperiodo extends GXProcedure
{
   public diasenperiodo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( diasenperiodo.class ), "" );
   }

   public diasenperiodo( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            int aP2 ,
                            short aP3 ,
                            java.util.Date aP4 ,
                            java.util.Date aP5 ,
                            boolean aP6 ,
                            boolean aP7 )
   {
      diasenperiodo.this.aP8 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 ,
                        java.util.Date aP4 ,
                        java.util.Date aP5 ,
                        boolean aP6 ,
                        boolean aP7 ,
                        short[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             java.util.Date aP4 ,
                             java.util.Date aP5 ,
                             boolean aP6 ,
                             boolean aP7 ,
                             short[] aP8 )
   {
      diasenperiodo.this.AV8CliCod = aP0;
      diasenperiodo.this.AV9EmpCod = aP1;
      diasenperiodo.this.AV10LegNumero = aP2;
      diasenperiodo.this.AV22cantDiasParm = aP3;
      diasenperiodo.this.AV19desdeFecha = aP4;
      diasenperiodo.this.AV20hastaFecha = aP5;
      diasenperiodo.this.AV23EstadoRemCorr = aP6;
      diasenperiodo.this.AV24restarFeriados = aP7;
      diasenperiodo.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ! (0==AV22cantDiasParm) )
      {
         AV21cantDias = AV22cantDiasParm ;
      }
      else
      {
         AV21cantDias = (short)(GXutil.ddiff(AV20hastaFecha,AV19desdeFecha)) ;
         AV21cantDias = (short)(AV21cantDias+1) ;
      }
      if ( ! AV23EstadoRemCorr )
      {
         GXv_boolean1[0] = AV11LegTrabDo ;
         GXv_boolean2[0] = AV12LegTrabLun ;
         GXv_boolean3[0] = AV13LegTrabMar ;
         GXv_boolean4[0] = AV14LegTrabMie ;
         GXv_boolean5[0] = AV15LegTrabJue ;
         GXv_boolean6[0] = AV16LegTrabVie ;
         GXv_boolean7[0] = AV17LegTrabSa ;
         new web.legdiastrabaja(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LegNumero, GXv_boolean1, GXv_boolean2, GXv_boolean3, GXv_boolean4, GXv_boolean5, GXv_boolean6, GXv_boolean7) ;
         diasenperiodo.this.AV11LegTrabDo = GXv_boolean1[0] ;
         diasenperiodo.this.AV12LegTrabLun = GXv_boolean2[0] ;
         diasenperiodo.this.AV13LegTrabMar = GXv_boolean3[0] ;
         diasenperiodo.this.AV14LegTrabMie = GXv_boolean4[0] ;
         diasenperiodo.this.AV15LegTrabJue = GXv_boolean5[0] ;
         diasenperiodo.this.AV16LegTrabVie = GXv_boolean6[0] ;
         diasenperiodo.this.AV17LegTrabSa = GXv_boolean7[0] ;
         if ( AV24restarFeriados )
         {
            GXt_int8 = AV25PaiCod ;
            GXv_int9[0] = GXt_int8 ;
            new web.clientegetpais(remoteHandle, context).execute( AV8CliCod, GXv_int9) ;
            diasenperiodo.this.GXt_int8 = GXv_int9[0] ;
            AV25PaiCod = GXt_int8 ;
         }
         AV18fecha = AV19desdeFecha ;
         while ( (( GXutil.resetTime(AV18fecha).before( GXutil.resetTime( AV20hastaFecha )) ) || ( GXutil.dateCompare(GXutil.resetTime(AV18fecha), GXutil.resetTime(AV20hastaFecha)) )) )
         {
            if ( GXutil.dow( AV18fecha) == 1 )
            {
               if ( ! AV11LegTrabDo )
               {
                  AV21cantDias = (short)(AV21cantDias-1) ;
               }
               else
               {
                  /* Execute user subroutine: 'FERIADO' */
                  S111 ();
                  if ( returnInSub )
                  {
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
            }
            else if ( GXutil.dow( AV18fecha) == 2 )
            {
               if ( ! AV12LegTrabLun )
               {
                  AV21cantDias = (short)(AV21cantDias-1) ;
               }
               else
               {
                  /* Execute user subroutine: 'FERIADO' */
                  S111 ();
                  if ( returnInSub )
                  {
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
            }
            else if ( GXutil.dow( AV18fecha) == 3 )
            {
               if ( ! AV13LegTrabMar )
               {
                  AV21cantDias = (short)(AV21cantDias-1) ;
               }
               else
               {
                  /* Execute user subroutine: 'FERIADO' */
                  S111 ();
                  if ( returnInSub )
                  {
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
            }
            else if ( GXutil.dow( AV18fecha) == 4 )
            {
               if ( ! AV14LegTrabMie )
               {
                  AV21cantDias = (short)(AV21cantDias-1) ;
               }
               else
               {
                  /* Execute user subroutine: 'FERIADO' */
                  S111 ();
                  if ( returnInSub )
                  {
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
            }
            else if ( GXutil.dow( AV18fecha) == 5 )
            {
               if ( ! AV15LegTrabJue )
               {
                  AV21cantDias = (short)(AV21cantDias-1) ;
               }
               else
               {
                  /* Execute user subroutine: 'FERIADO' */
                  S111 ();
                  if ( returnInSub )
                  {
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
            }
            else if ( GXutil.dow( AV18fecha) == 6 )
            {
               if ( ! AV16LegTrabVie )
               {
                  AV21cantDias = (short)(AV21cantDias-1) ;
               }
               else
               {
                  /* Execute user subroutine: 'FERIADO' */
                  S111 ();
                  if ( returnInSub )
                  {
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
            }
            else if ( GXutil.dow( AV18fecha) == 7 )
            {
               if ( ! AV17LegTrabSa )
               {
                  AV21cantDias = (short)(AV21cantDias-1) ;
               }
               else
               {
                  /* Execute user subroutine: 'FERIADO' */
                  S111 ();
                  if ( returnInSub )
                  {
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
            }
            AV18fecha = GXutil.dadd( AV18fecha, (1)) ;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'FERIADO' Routine */
      returnInSub = false ;
      if ( AV24restarFeriados )
      {
         GXv_boolean7[0] = AV26feriadoEs ;
         new web.diaesferiado(remoteHandle, context).execute( AV25PaiCod, AV18fecha, GXv_boolean7) ;
         diasenperiodo.this.AV26feriadoEs = GXv_boolean7[0] ;
         if ( AV26feriadoEs )
         {
            AV21cantDias = (short)(AV21cantDias-1) ;
         }
      }
   }

   protected void cleanup( )
   {
      this.aP8[0] = diasenperiodo.this.AV21cantDias;
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
      GXv_int9 = new short[1] ;
      AV18fecha = GXutil.nullDate() ;
      GXv_boolean7 = new boolean[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short AV22cantDiasParm ;
   private short AV21cantDias ;
   private short AV25PaiCod ;
   private short GXt_int8 ;
   private short GXv_int9[] ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LegNumero ;
   private java.util.Date AV19desdeFecha ;
   private java.util.Date AV20hastaFecha ;
   private java.util.Date AV18fecha ;
   private boolean AV23EstadoRemCorr ;
   private boolean AV24restarFeriados ;
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
   private boolean returnInSub ;
   private boolean AV26feriadoEs ;
   private boolean GXv_boolean7[] ;
   private short[] aP8 ;
}

