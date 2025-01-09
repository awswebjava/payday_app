package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class diferenciamesesydias extends GXProcedure
{
   public diferenciamesesydias( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( diferenciamesesydias.class ), "" );
   }

   public diferenciamesesydias( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            java.util.Date aP1 ,
                            java.util.Date aP2 ,
                            short aP3 ,
                            boolean aP4 ,
                            short[] aP5 ,
                            short[] aP6 )
   {
      diferenciamesesydias.this.aP7 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        java.util.Date aP1 ,
                        java.util.Date aP2 ,
                        short aP3 ,
                        boolean aP4 ,
                        short[] aP5 ,
                        short[] aP6 ,
                        short[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             java.util.Date aP1 ,
                             java.util.Date aP2 ,
                             short aP3 ,
                             boolean aP4 ,
                             short[] aP5 ,
                             short[] aP6 ,
                             short[] aP7 )
   {
      diferenciamesesydias.this.AV17CliCod = aP0;
      diferenciamesesydias.this.AV12parmdesdeFecha = aP1;
      diferenciamesesydias.this.AV13parmhastaFecha = aP2;
      diferenciamesesydias.this.AV14limite = aP3;
      diferenciamesesydias.this.AV20forzarDiasReales = aP4;
      diferenciamesesydias.this.aP5 = aP5;
      diferenciamesesydias.this.aP6 = aP6;
      diferenciamesesydias.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9desdeFecha = AV12parmdesdeFecha ;
      AV10hastaFecha = AV13parmhastaFecha ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV17CliCod, AV27Pgmname, httpContext.getMessage( "&&desdeFecha ", "")+GXutil.trim( localUtil.dtoc( AV9desdeFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " hasta ", "")+GXutil.trim( localUtil.dtoc( AV10hastaFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      AV16auxDesdeFecha = localUtil.ymdtod( GXutil.year( AV9desdeFecha), GXutil.month( AV9desdeFecha), 1) ;
      AV23auxHastaFecha = localUtil.ymdtod( GXutil.year( AV10hastaFecha), GXutil.month( AV10hastaFecha), 1) ;
      if ( ( GXutil.year( AV16auxDesdeFecha) == GXutil.year( AV23auxHastaFecha) ) && ( GXutil.month( AV16auxDesdeFecha) == GXutil.month( AV23auxHastaFecha) ) )
      {
         AV24anteriorDesdeFecha = AV9desdeFecha ;
      }
      AV24anteriorDesdeFecha = AV9desdeFecha ;
      while ( (( GXutil.resetTime(AV16auxDesdeFecha).before( GXutil.resetTime( AV23auxHastaFecha )) ) || ( GXutil.dateCompare(GXutil.resetTime(AV16auxDesdeFecha), GXutil.resetTime(AV23auxHastaFecha)) )) )
      {
         if ( AV8cantidad > AV14limite )
         {
            if (true) break;
         }
         new web.msgdebug_prod2(remoteHandle, context).execute( AV17CliCod, AV27Pgmname, httpContext.getMessage( "!recorre &anteriorDesdeFecha ", "")+GXutil.trim( localUtil.dtoc( AV24anteriorDesdeFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &hastaFecha ", "")+GXutil.trim( localUtil.dtoc( AV10hastaFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
         if ( ( GXutil.year( AV9desdeFecha) == GXutil.year( AV10hastaFecha) ) && ( GXutil.month( AV9desdeFecha) == GXutil.month( AV10hastaFecha) ) )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV17CliCod, AV27Pgmname, httpContext.getMessage( "ultimo mes ", "")) ;
            if ( GXutil.day( AV24anteriorDesdeFecha) <= GXutil.day( AV10hastaFecha) )
            {
               if ( GXutil.dateCompare(GXutil.resetTime(AV10hastaFecha), GXutil.resetTime(GXutil.eomdate( AV10hastaFecha))) && ( GXutil.day( AV24anteriorDesdeFecha) == 1 ) )
               {
                  /* Execute user subroutine: 'SUMAR MES COMPLETO' */
                  S111 ();
                  if ( returnInSub )
                  {
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
               else
               {
                  AV21remanenteDias = (short)(GXutil.day( AV10hastaFecha)) ;
                  AV21remanenteDias = (short)(AV21remanenteDias-(GXutil.day( AV24anteriorDesdeFecha))) ;
                  AV15dias = (short)(AV15dias+AV21remanenteDias) ;
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV17CliCod, AV27Pgmname, httpContext.getMessage( "le sumo ", "")+GXutil.trim( GXutil.str( AV21remanenteDias, 4, 0))) ;
               }
            }
            else
            {
               AV22auxRemanenteDias = (short)(GXutil.day( AV24anteriorDesdeFecha)-GXutil.day( AV10hastaFecha)) ;
               AV15dias = (short)(AV15dias-AV22auxRemanenteDias) ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV17CliCod, AV27Pgmname, httpContext.getMessage( "le resto ", "")+GXutil.trim( localUtil.dtoc( AV9desdeFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
            }
            new web.msgdebug_prod2(remoteHandle, context).execute( AV17CliCod, AV27Pgmname, httpContext.getMessage( "!!dias ", "")+GXutil.trim( GXutil.str( AV15dias, 4, 0))+httpContext.getMessage( " dm ", "")+GXutil.str( GXutil.day( GXutil.eomdate( AV9desdeFecha)), 10, 0)) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV17CliCod, AV27Pgmname, httpContext.getMessage( "&auxDesdeFecha ", "")+GXutil.trim( localUtil.dtoc( AV16auxDesdeFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &anteriorDesdeFecha ", "")+GXutil.trim( localUtil.dtoc( AV24anteriorDesdeFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
            if ( ( AV15dias < GXutil.day( GXutil.eomdate( AV16auxDesdeFecha)) ) && GXutil.resetTime(AV16auxDesdeFecha).after( GXutil.resetTime( AV24anteriorDesdeFecha )) )
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV17CliCod, AV27Pgmname, httpContext.getMessage( "&anteriorDesdeFecha.EndOfMonth().Day() ", "")+GXutil.trim( GXutil.str( GXutil.day( GXutil.eomdate( AV24anteriorDesdeFecha)), 10, 0))) ;
               if ( ( AV15dias < GXutil.day( GXutil.eomdate( AV24anteriorDesdeFecha)) ) && ( AV8cantidad == 0 ) )
               {
                  AV21remanenteDias = (short)(0) ;
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV17CliCod, AV27Pgmname, httpContext.getMessage( "cerea", "")) ;
               }
            }
            new web.msgdebug_prod2(remoteHandle, context).execute( AV17CliCod, AV27Pgmname, httpContext.getMessage( "sumo ", "")+GXutil.trim( GXutil.str( GXutil.day( AV10hastaFecha), 10, 0))+httpContext.getMessage( " queda ", "")+GXutil.trim( GXutil.str( AV15dias, 4, 0))) ;
         }
         else
         {
            /* Execute user subroutine: 'SUMAR MES COMPLETO' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            new web.msgdebug_prod2(remoteHandle, context).execute( AV17CliCod, AV27Pgmname, httpContext.getMessage( "(mes) sumo ", "")+GXutil.trim( GXutil.str( AV18diasMes, 2, 0))+httpContext.getMessage( " queda ", "")+GXutil.trim( GXutil.str( AV15dias, 4, 0))) ;
         }
         AV24anteriorDesdeFecha = AV9desdeFecha ;
         AV9desdeFecha = GXutil.addmth( AV9desdeFecha, (short)(1)) ;
         AV16auxDesdeFecha = GXutil.addmth( AV16auxDesdeFecha, (short)(1)) ;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV17CliCod, AV27Pgmname, httpContext.getMessage( "fin cantidad ", "")+GXutil.trim( GXutil.str( AV8cantidad, 4, 0))+httpContext.getMessage( " dias ", "")+GXutil.trim( GXutil.str( AV15dias, 4, 0))+httpContext.getMessage( " &desdeFecha ", "")+GXutil.trim( localUtil.dtoc( AV9desdeFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &hastaFecha ", "")+GXutil.trim( localUtil.dtoc( AV10hastaFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'SUMAR MES COMPLETO' Routine */
      returnInSub = false ;
      AV8cantidad = (short)(AV8cantidad+1) ;
      if ( AV20forzarDiasReales )
      {
         AV19auxFecha = GXutil.eomdate( AV9desdeFecha) ;
         AV18diasMes = (byte)(GXutil.day( AV19auxFecha)) ;
      }
      else
      {
         GXv_int1[0] = AV18diasMes ;
         new web.diasmes(remoteHandle, context).execute( AV17CliCod, AV9desdeFecha, GXv_int1) ;
         diferenciamesesydias.this.AV18diasMes = (byte)((byte)(GXv_int1[0])) ;
      }
      AV15dias = (short)(AV15dias+AV18diasMes) ;
   }

   protected void cleanup( )
   {
      this.aP5[0] = diferenciamesesydias.this.AV8cantidad;
      this.aP6[0] = diferenciamesesydias.this.AV15dias;
      this.aP7[0] = diferenciamesesydias.this.AV21remanenteDias;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9desdeFecha = GXutil.nullDate() ;
      AV10hastaFecha = GXutil.nullDate() ;
      AV27Pgmname = "" ;
      AV16auxDesdeFecha = GXutil.nullDate() ;
      AV23auxHastaFecha = GXutil.nullDate() ;
      AV24anteriorDesdeFecha = GXutil.nullDate() ;
      AV19auxFecha = GXutil.nullDate() ;
      GXv_int1 = new short[1] ;
      AV27Pgmname = "diferenciaMesesYDias" ;
      /* GeneXus formulas. */
      AV27Pgmname = "diferenciaMesesYDias" ;
      Gx_err = (short)(0) ;
   }

   private byte AV18diasMes ;
   private short AV14limite ;
   private short AV8cantidad ;
   private short AV15dias ;
   private short AV21remanenteDias ;
   private short AV22auxRemanenteDias ;
   private short GXv_int1[] ;
   private short Gx_err ;
   private int AV17CliCod ;
   private String AV27Pgmname ;
   private java.util.Date AV12parmdesdeFecha ;
   private java.util.Date AV13parmhastaFecha ;
   private java.util.Date AV9desdeFecha ;
   private java.util.Date AV10hastaFecha ;
   private java.util.Date AV16auxDesdeFecha ;
   private java.util.Date AV23auxHastaFecha ;
   private java.util.Date AV24anteriorDesdeFecha ;
   private java.util.Date AV19auxFecha ;
   private boolean AV20forzarDiasReales ;
   private boolean returnInSub ;
   private short[] aP7 ;
   private short[] aP5 ;
   private short[] aP6 ;
}

