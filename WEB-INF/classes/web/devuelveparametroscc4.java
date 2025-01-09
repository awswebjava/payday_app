package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class devuelveparametroscc4 extends GXProcedure
{
   public devuelveparametroscc4( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( devuelveparametroscc4.class ), "" );
   }

   public devuelveparametroscc4( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem>[] aP3 )
   {
      devuelveparametroscc4.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem>[] aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem>[] aP3 ,
                             String[] aP4 )
   {
      devuelveparametroscc4.this.AV13clicod = aP0;
      devuelveparametroscc4.this.AV20idOperando = aP1;
      devuelveparametroscc4.this.AV25Operando = aP2;
      devuelveparametroscc4.this.aP3 = aP3;
      devuelveparametroscc4.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV29split = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV25Operando," ")) ;
      if ( AV29split.size() > 0 )
      {
         AV29split.removeItem(1);
      }
      AV33usaRangoDefinido = true ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV45Pgmname, httpContext.getMessage( " &split.Count ", "")+GXutil.trim( GXutil.str( AV29split.size(), 9, 0))+httpContext.getMessage( " operando ", "")+AV25Operando) ;
      GXv_int1[0] = AV26PaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV13clicod, GXv_int1) ;
      devuelveparametroscc4.this.AV26PaiCod = GXv_int1[0] ;
      GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem2[0] = AV10cal_par_valores ;
      new web.cargarsdtparametroscalculo(remoteHandle, context).execute( AV26PaiCod, AV20idOperando, GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem2) ;
      AV10cal_par_valores = GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem2[0] ;
      if ( AV29split.size() == 0 )
      {
         if ( AV10cal_par_valores.size() > 0 )
         {
            if ( AV10cal_par_valores.size() > 1 )
            {
               AV18error = httpContext.getMessage( "Faltan parámetros ", "") ;
            }
            else
            {
               AV18error = httpContext.getMessage( "Falta parámetro de ", "") + GXutil.trim( ((web.Sdtcal_par_valores_cal_par_valoresItem)AV10cal_par_valores.elementAt(-1+1)).getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparnombre()) ;
            }
            AV18error += httpContext.getMessage( " en ", "") + GXutil.trim( httpContext.getMessage( web.gxdomainoperandos.getDescription(httpContext,(String)AV20idOperando), "")) ;
         }
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      else
      {
         AV21item = (short)(2) ;
         AV24ObligatoriosOK = true ;
         GXv_objcol_char3[0] = AV29split ;
         GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem2[0] = AV10cal_par_valores ;
         GXv_char4[0] = AV18error ;
         new web.calparvalidayasigna(remoteHandle, context).execute( AV26PaiCod, AV13clicod, AV20idOperando, AV25Operando, true, GXv_objcol_char3, GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem2, GXv_char4) ;
         AV29split = GXv_objcol_char3[0] ;
         AV10cal_par_valores = GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem2[0] ;
         devuelveparametroscc4.this.AV18error = GXv_char4[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV45Pgmname, httpContext.getMessage( " &split.Count despues de obligatorios ", "")+GXutil.trim( GXutil.str( AV29split.size(), 9, 0))) ;
         if ( ! (GXutil.strcmp("", AV18error)==0) )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( AV29split.size() > 0 )
         {
            GXv_objcol_char3[0] = AV29split ;
            GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem2[0] = AV10cal_par_valores ;
            GXv_char4[0] = AV18error ;
            new web.calparvalidayasigna(remoteHandle, context).execute( AV26PaiCod, AV13clicod, AV20idOperando, AV25Operando, false, GXv_objcol_char3, GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem2, GXv_char4) ;
            AV29split = GXv_objcol_char3[0] ;
            AV10cal_par_valores = GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem2[0] ;
            devuelveparametroscc4.this.AV18error = GXv_char4[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV45Pgmname, httpContext.getMessage( " &split.Count despues de otros ", "")+GXutil.trim( GXutil.str( AV29split.size(), 9, 0))) ;
            if ( ! (GXutil.strcmp("", AV18error)==0) )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         AV46GXV1 = 1 ;
         while ( AV46GXV1 <= AV10cal_par_valores.size() )
         {
            AV22itemCalParVal = (web.Sdtcal_par_valores_cal_par_valoresItem)((web.Sdtcal_par_valores_cal_par_valoresItem)AV10cal_par_valores.elementAt(-1+AV46GXV1));
            if ( (GXutil.strcmp("", AV22itemCalParVal.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Value())==0) )
            {
               AV22itemCalParVal.setgxTv_Sdtcal_par_valores_cal_par_valoresItem_Value( GXutil.trim( AV22itemCalParVal.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpardef()) );
            }
            AV46GXV1 = (int)(AV46GXV1+1) ;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV45Pgmname, httpContext.getMessage( "validar dependencias", "")) ;
         AV37auxCal_par_valores.fromJSonString(AV10cal_par_valores.toJSonString(false), null);
         AV47GXV2 = 1 ;
         while ( AV47GXV2 <= AV10cal_par_valores.size() )
         {
            AV22itemCalParVal = (web.Sdtcal_par_valores_cal_par_valoresItem)((web.Sdtcal_par_valores_cal_par_valoresItem)AV10cal_par_valores.elementAt(-1+AV47GXV2));
            new web.msgdebug_prod(remoteHandle, context).execute( AV45Pgmname, AV22itemCalParVal.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparid()+": "+AV22itemCalParVal.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Value()) ;
            if ( ! (GXutil.strcmp("", AV22itemCalParVal.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Value())==0) && ! (0==AV22itemCalParVal.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpargrpdep()) )
            {
               AV42parametroDependienteCalParNombre = AV22itemCalParVal.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparnombre() ;
               AV40CalParGrpDep = AV22itemCalParVal.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpargrpdep() ;
               AV39dependenciaOK = false ;
               AV48GXV3 = 1 ;
               while ( AV48GXV3 <= AV37auxCal_par_valores.size() )
               {
                  AV38auxItem = (web.Sdtcal_par_valores_cal_par_valoresItem)((web.Sdtcal_par_valores_cal_par_valoresItem)AV37auxCal_par_valores.elementAt(-1+AV48GXV3));
                  if ( AV38auxItem.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpargrp() == AV40CalParGrpDep )
                  {
                     AV41dependenciaCalParNombre = AV38auxItem.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparnombre() ;
                     if ( ! (GXutil.strcmp("", AV38auxItem.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Value())==0) )
                     {
                        AV39dependenciaOK = true ;
                     }
                     if (true) break;
                  }
                  AV48GXV3 = (int)(AV48GXV3+1) ;
               }
               if ( ! AV39dependenciaOK )
               {
                  AV18error = httpContext.getMessage( "Falta dependencia ", "") + GXutil.trim( AV41dependenciaCalParNombre) + httpContext.getMessage( " para parámetro ", "") + GXutil.trim( AV42parametroDependienteCalParNombre) ;
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            AV47GXV2 = (int)(AV47GXV2+1) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = devuelveparametroscc4.this.AV10cal_par_valores;
      this.aP4[0] = devuelveparametroscc4.this.AV18error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10cal_par_valores = new GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem>(web.Sdtcal_par_valores_cal_par_valoresItem.class, "cal_par_valoresItem", "PayDay", remoteHandle);
      AV18error = "" ;
      AV29split = new GXSimpleCollection<String>(String.class, "internal", "");
      AV45Pgmname = "" ;
      GXv_int1 = new short[1] ;
      GXv_objcol_char3 = new GXSimpleCollection[1] ;
      GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem2 = new GXBaseCollection[1] ;
      GXv_char4 = new String[1] ;
      AV22itemCalParVal = new web.Sdtcal_par_valores_cal_par_valoresItem(remoteHandle, context);
      AV37auxCal_par_valores = new GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem>(web.Sdtcal_par_valores_cal_par_valoresItem.class, "cal_par_valoresItem", "PayDay", remoteHandle);
      AV42parametroDependienteCalParNombre = "" ;
      AV38auxItem = new web.Sdtcal_par_valores_cal_par_valoresItem(remoteHandle, context);
      AV41dependenciaCalParNombre = "" ;
      AV45Pgmname = "devuelveParametrosCC4" ;
      /* GeneXus formulas. */
      AV45Pgmname = "devuelveParametrosCC4" ;
      Gx_err = (short)(0) ;
   }

   private byte AV40CalParGrpDep ;
   private short AV26PaiCod ;
   private short GXv_int1[] ;
   private short AV21item ;
   private short Gx_err ;
   private int AV13clicod ;
   private int AV46GXV1 ;
   private int AV47GXV2 ;
   private int AV48GXV3 ;
   private String AV20idOperando ;
   private String AV45Pgmname ;
   private String GXv_char4[] ;
   private boolean AV33usaRangoDefinido ;
   private boolean returnInSub ;
   private boolean AV24ObligatoriosOK ;
   private boolean AV39dependenciaOK ;
   private String AV25Operando ;
   private String AV18error ;
   private String AV42parametroDependienteCalParNombre ;
   private String AV41dependenciaCalParNombre ;
   private String[] aP4 ;
   private GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem>[] aP3 ;
   private GXSimpleCollection<String> AV29split ;
   private GXSimpleCollection<String> GXv_objcol_char3[] ;
   private GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem> AV10cal_par_valores ;
   private GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem> GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem2[] ;
   private GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem> AV37auxCal_par_valores ;
   private web.Sdtcal_par_valores_cal_par_valoresItem AV22itemCalParVal ;
   private web.Sdtcal_par_valores_cal_par_valoresItem AV38auxItem ;
}

