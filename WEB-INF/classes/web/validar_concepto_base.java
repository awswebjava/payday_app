package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class validar_concepto_base extends GXProcedure
{
   public validar_concepto_base( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( validar_concepto_base.class ), "" );
   }

   public validar_concepto_base( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              String aP3 ,
                              java.util.Date aP4 ,
                              java.util.Date aP5 ,
                              java.math.BigDecimal aP6 ,
                              byte aP7 ,
                              String aP8 ,
                              boolean[] aP9 )
   {
      validar_concepto_base.this.aP10 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        java.util.Date aP4 ,
                        java.util.Date aP5 ,
                        java.math.BigDecimal aP6 ,
                        byte aP7 ,
                        String aP8 ,
                        boolean[] aP9 ,
                        boolean[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             java.util.Date aP4 ,
                             java.util.Date aP5 ,
                             java.math.BigDecimal aP6 ,
                             byte aP7 ,
                             String aP8 ,
                             boolean[] aP9 ,
                             boolean[] aP10 )
   {
      validar_concepto_base.this.AV14CliCod = aP0;
      validar_concepto_base.this.AV15EmpCod = aP1;
      validar_concepto_base.this.AV16LegNumero = aP2;
      validar_concepto_base.this.AV17ConCodigo = aP3;
      validar_concepto_base.this.AV18desde_LiqPeriodo = aP4;
      validar_concepto_base.this.AV19hasta_LiqPeriodo = aP5;
      validar_concepto_base.this.AV21proporcionHabitualPorUnaje = aP6;
      validar_concepto_base.this.AV24es_base = aP7;
      validar_concepto_base.this.AV25tipo_tarifa = aP8;
      validar_concepto_base.this.aP9 = aP9;
      validar_concepto_base.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV12agregar = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, "1") ;
      if ( AV24es_base == 1 )
      {
         AV12agregar = true ;
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, "2") ;
         if ( AV24es_base == 4 )
         {
            /* Execute user subroutine: 'CHEQUEAR HABITUAL' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, "3") ;
            AV12agregar = AV10habitualEs ;
         }
         else
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, "4") ;
            if ( ( AV24es_base == 2 ) && ( GXutil.strcmp(AV25tipo_tarifa, "H") == 0 ) )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, "5") ;
               AV12agregar = true ;
            }
            else
            {
               if ( ( AV24es_base == 3 ) && ( GXutil.strcmp(AV25tipo_tarifa, "P") == 0 ) )
               {
                  AV12agregar = true ;
               }
               else
               {
                  if ( ( AV24es_base == 5 ) && ( GXutil.strcmp(AV25tipo_tarifa, "H") == 0 ) )
                  {
                     /* Execute user subroutine: 'CHEQUEAR HABITUAL' */
                     S111 ();
                     if ( returnInSub )
                     {
                        returnInSub = true;
                        cleanup();
                        if (true) return;
                     }
                     AV12agregar = AV10habitualEs ;
                  }
                  else
                  {
                     if ( ( AV24es_base == 6 ) && ( GXutil.strcmp(AV25tipo_tarifa, "P") == 0 ) )
                     {
                        /* Execute user subroutine: 'CHEQUEAR HABITUAL' */
                        S111 ();
                        if ( returnInSub )
                        {
                           returnInSub = true;
                           cleanup();
                           if (true) return;
                        }
                        AV12agregar = AV10habitualEs ;
                     }
                  }
               }
            }
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'CHEQUEAR HABITUAL' Routine */
      returnInSub = false ;
      GXv_boolean1[0] = AV10habitualEs ;
      new web.conceptoeshabitual(remoteHandle, context).execute( AV14CliCod, AV15EmpCod, AV16LegNumero, AV17ConCodigo, AV18desde_LiqPeriodo, AV19hasta_LiqPeriodo, AV21proporcionHabitualPorUnaje, GXv_boolean1) ;
      validar_concepto_base.this.AV10habitualEs = GXv_boolean1[0] ;
      if ( ! AV10habitualEs )
      {
         AV22descartoPorHabitual = true ;
      }
   }

   protected void cleanup( )
   {
      this.aP9[0] = validar_concepto_base.this.AV12agregar;
      this.aP10[0] = validar_concepto_base.this.AV22descartoPorHabitual;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV28Pgmname = "" ;
      GXv_boolean1 = new boolean[1] ;
      AV28Pgmname = "validar_concepto_base" ;
      /* GeneXus formulas. */
      AV28Pgmname = "validar_concepto_base" ;
      Gx_err = (short)(0) ;
   }

   private byte AV24es_base ;
   private short AV15EmpCod ;
   private short Gx_err ;
   private int AV14CliCod ;
   private int AV16LegNumero ;
   private java.math.BigDecimal AV21proporcionHabitualPorUnaje ;
   private String AV17ConCodigo ;
   private String AV25tipo_tarifa ;
   private String AV28Pgmname ;
   private java.util.Date AV18desde_LiqPeriodo ;
   private java.util.Date AV19hasta_LiqPeriodo ;
   private boolean AV12agregar ;
   private boolean AV22descartoPorHabitual ;
   private boolean returnInSub ;
   private boolean AV10habitualEs ;
   private boolean GXv_boolean1[] ;
   private boolean[] aP10 ;
   private boolean[] aP9 ;
}

