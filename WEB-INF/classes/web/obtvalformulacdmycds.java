package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obtvalformulacdmycds extends GXProcedure
{
   public obtvalformulacdmycds( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obtvalformulacdmycds.class ), "" );
   }

   public obtvalformulacdmycds( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( int aP0 ,
                          short aP1 ,
                          int aP2 ,
                          int aP3 ,
                          java.util.Date aP4 ,
                          String aP5 ,
                          java.util.Date aP6 ,
                          boolean aP7 )
   {
      obtvalformulacdmycds.this.aP8 = new int[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        java.util.Date aP6 ,
                        boolean aP7 ,
                        int[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             java.util.Date aP6 ,
                             boolean aP7 ,
                             int[] aP8 )
   {
      obtvalformulacdmycds.this.AV15CliCod = aP0;
      obtvalformulacdmycds.this.AV28EmpCod = aP1;
      obtvalformulacdmycds.this.AV36LiqNro = aP2;
      obtvalformulacdmycds.this.AV29LegNumero = aP3;
      obtvalformulacdmycds.this.AV30LiqPeriodo = aP4;
      obtvalformulacdmycds.this.AV9Param = aP5;
      obtvalformulacdmycds.this.AV11Fecha = aP6;
      obtvalformulacdmycds.this.AV32diasMesPosta = aP7;
      obtvalformulacdmycds.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV13diasMes = "[dias_mes]" ;
      AV39diasMesEgreso = "[dias_mes_egreso]" ;
      AV14diasSemestre = "[dias_semestre]" ;
      if ( GXutil.strcmp(AV9Param, AV39diasMesEgreso) == 0 )
      {
         AV8Cantidad = GXutil.day( GXutil.eomdate( AV11Fecha)) ;
      }
      else
      {
         GXv_int1[0] = (short)(AV31tiempo) ;
         new web.diasmes(remoteHandle, context).execute( AV15CliCod, AV11Fecha, GXv_int1) ;
         obtvalformulacdmycds.this.AV31tiempo = GXv_int1[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV42Pgmname, httpContext.getMessage( "clicod ", "")+GXutil.trim( GXutil.str( AV15CliCod, 6, 0))+httpContext.getMessage( " &Param \"", "")+AV9Param+httpContext.getMessage( "\" &diasSemestre \"", "")+AV14diasSemestre+"\""+httpContext.getMessage( " &Fecha ", "")+GXutil.trim( localUtil.dtoc( AV11Fecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " tiempo ", "")+GXutil.trim( GXutil.str( AV31tiempo, 8, 0))) ;
         if ( GXutil.strcmp(AV9Param, AV13diasMes) == 0 )
         {
            AV8Cantidad = AV31tiempo ;
         }
         else if ( GXutil.strcmp(AV9Param, AV14diasSemestre) == 0 )
         {
            AV16anio = (short)(GXutil.year( AV11Fecha)) ;
            if ( GXutil.month( AV11Fecha) <= 6 )
            {
               AV20desde = (short)(1) ;
               AV21hasta = (short)(6) ;
            }
            else
            {
               AV20desde = (short)(7) ;
               AV21hasta = (short)(12) ;
            }
            AV43X = AV20desde ;
            while ( AV43X <= AV21hasta )
            {
               AV8Cantidad = (int)(AV8Cantidad+AV31tiempo) ;
               AV43X = (short)(AV43X+1) ;
            }
         }
      }
      new web.msgdebug2(remoteHandle, context).execute( AV42Pgmname, httpContext.getMessage( "devuelve ", "")+GXutil.trim( GXutil.str( AV8Cantidad, 6, 0))+httpContext.getMessage( " &FechaAux ", "")+GXutil.trim( localUtil.dtoc( AV12FechaAux, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &Mes ", "")+AV10Mes) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP8[0] = obtvalformulacdmycds.this.AV8Cantidad;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13diasMes = "" ;
      AV39diasMesEgreso = "" ;
      AV14diasSemestre = "" ;
      GXv_int1 = new short[1] ;
      AV42Pgmname = "" ;
      AV12FechaAux = GXutil.nullDate() ;
      AV10Mes = "" ;
      AV42Pgmname = "ObtValFormulaCDMyCDS" ;
      /* GeneXus formulas. */
      AV42Pgmname = "ObtValFormulaCDMyCDS" ;
      Gx_err = (short)(0) ;
   }

   private short AV28EmpCod ;
   private short GXv_int1[] ;
   private short AV16anio ;
   private short AV20desde ;
   private short AV21hasta ;
   private short AV43X ;
   private short Gx_err ;
   private int AV15CliCod ;
   private int AV36LiqNro ;
   private int AV29LegNumero ;
   private int AV8Cantidad ;
   private int AV31tiempo ;
   private String AV9Param ;
   private String AV13diasMes ;
   private String AV39diasMesEgreso ;
   private String AV14diasSemestre ;
   private String AV42Pgmname ;
   private String AV10Mes ;
   private java.util.Date AV30LiqPeriodo ;
   private java.util.Date AV11Fecha ;
   private java.util.Date AV12FechaAux ;
   private boolean AV32diasMesPosta ;
   private int[] aP8 ;
}

