package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class calparvalidayasigna extends GXProcedure
{
   public calparvalidayasigna( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calparvalidayasigna.class ), "" );
   }

   public calparvalidayasigna( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( short aP0 ,
                             int aP1 ,
                             String aP2 ,
                             String aP3 ,
                             boolean aP4 ,
                             GXSimpleCollection<String>[] aP5 ,
                             GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem>[] aP6 )
   {
      calparvalidayasigna.this.aP7 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( short aP0 ,
                        int aP1 ,
                        String aP2 ,
                        String aP3 ,
                        boolean aP4 ,
                        GXSimpleCollection<String>[] aP5 ,
                        GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem>[] aP6 ,
                        String[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( short aP0 ,
                             int aP1 ,
                             String aP2 ,
                             String aP3 ,
                             boolean aP4 ,
                             GXSimpleCollection<String>[] aP5 ,
                             GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem>[] aP6 ,
                             String[] aP7 )
   {
      calparvalidayasigna.this.AV29PaiCod = aP0;
      calparvalidayasigna.this.AV18CliCod = aP1;
      calparvalidayasigna.this.AV27idOperando = aP2;
      calparvalidayasigna.this.AV36Operando = aP3;
      calparvalidayasigna.this.AV16CalParObl = aP4;
      calparvalidayasigna.this.AV32split = aP5[0];
      this.aP5 = aP5;
      calparvalidayasigna.this.AV14cal_par_valores = aP6[0];
      this.aP6 = aP6;
      calparvalidayasigna.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV37auxcal_par_valores.fromJSonString(AV14cal_par_valores.toJSonString(false), null);
      new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, httpContext.getMessage( "------------)))))&CalParObl ", "")+GXutil.trim( GXutil.booltostr( AV16CalParObl))) ;
      /* Using cursor P02052 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV29PaiCod), AV27idOperando, Boolean.valueOf(AV16CalParObl)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk2052 = false ;
         A46PaiCod = P02052_A46PaiCod[0] ;
         A74idOperando = P02052_A74idOperando[0] ;
         A2106CalParObl = P02052_A2106CalParObl[0] ;
         A2098CalParId = P02052_A2098CalParId[0] ;
         A2110CalParNombre = P02052_A2110CalParNombre[0] ;
         A2111CalParValLista = P02052_A2111CalParValLista[0] ;
         A2104CalParGrp = P02052_A2104CalParGrp[0] ;
         AV17cant = (short)(0) ;
         AV23errorCant = (short)(0) ;
         AV13bienCant = (short)(0) ;
         AV8aux2Error = "" ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, httpContext.getMessage( "CalParGrp ", "")+GXutil.trim( GXutil.str( A2104CalParGrp, 2, 0))) ;
         while ( (pr_default.getStatus(0) != 101) && ( P02052_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(P02052_A74idOperando[0], A74idOperando) == 0 ) && ( P02052_A2104CalParGrp[0] == A2104CalParGrp ) )
         {
            brk2052 = false ;
            A2106CalParObl = P02052_A2106CalParObl[0] ;
            A2098CalParId = P02052_A2098CalParId[0] ;
            A2110CalParNombre = P02052_A2110CalParNombre[0] ;
            A2111CalParValLista = P02052_A2111CalParValLista[0] ;
            if ( A2106CalParObl == AV16CalParObl )
            {
               AV25hay = false ;
               AV17cant = (short)(AV17cant+1) ;
               AV43GXV1 = 1 ;
               while ( AV43GXV1 <= AV14cal_par_valores.size() )
               {
                  AV28item = (web.Sdtcal_par_valores_cal_par_valoresItem)((web.Sdtcal_par_valores_cal_par_valoresItem)AV14cal_par_valores.elementAt(-1+AV43GXV1));
                  if ( GXutil.strcmp(AV28item.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparid(), A2098CalParId) == 0 )
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, httpContext.getMessage( "CalParId ", "")+A2098CalParId) ;
                     GXv_Sdtcal_par_valores_cal_par_valoresItem1[0] = AV28item;
                     GXv_objcol_char2[0] = AV32split ;
                     GXv_char3[0] = AV11auxError ;
                     GXv_objcol_char4[0] = AV12auxInvalidas ;
                     new web.calparvalidavalor(remoteHandle, context).execute( AV18CliCod, AV29PaiCod, AV37auxcal_par_valores, GXv_Sdtcal_par_valores_cal_par_valoresItem1, GXv_objcol_char2, GXv_char3, GXv_objcol_char4) ;
                     AV28item = GXv_Sdtcal_par_valores_cal_par_valoresItem1[0] ;
                     AV32split = GXv_objcol_char2[0] ;
                     calparvalidayasigna.this.AV11auxError = GXv_char3[0] ;
                     AV12auxInvalidas = GXv_objcol_char4[0] ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, httpContext.getMessage( "!splitcount ", "")+GXutil.trim( GXutil.str( AV32split.size(), 9, 0))+httpContext.getMessage( " &auxError ", "")+AV11auxError) ;
                     if ( ! (GXutil.strcmp("", AV11auxError)==0) )
                     {
                        AV8aux2Error += GXutil.trim( AV11auxError) + ". " ;
                        AV23errorCant = (short)(AV23errorCant+1) ;
                     }
                     else
                     {
                        AV13bienCant = (short)(AV13bienCant+1) ;
                        AV10auxBien += GXutil.trim( AV28item.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Value()) + "( " + GXutil.trim( A2110CalParNombre) + "), " ;
                     }
                     if (true) break;
                  }
                  AV43GXV1 = (int)(AV43GXV1+1) ;
               }
            }
            brk2052 = true ;
            pr_default.readNext(0);
         }
         if ( ( AV17cant > 1 ) && ( AV13bienCant == AV17cant ) )
         {
            AV22error = httpContext.getMessage( "Solo se permite 1 valor del mismo grupo de parámetros en \"", "") + GXutil.trim( AV36Operando) + "\"" ;
            if ( AV16CalParObl )
            {
               AV22error += httpContext.getMessage( "obligatorios", "") ;
            }
            AV22error += httpContext.getMessage( ". Debe ingresar alguno de estos 2: ", "") + AV10auxBien ;
            pr_default.close(0);
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         else
         {
            if ( ( AV16CalParObl ) && ( AV17cant == AV23errorCant ) )
            {
               AV22error = httpContext.getMessage( "Error al validar parámetro en \"", "") + GXutil.trim( AV36Operando) + "\": " + GXutil.trim( AV8aux2Error) ;
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         if ( ! brk2052 )
         {
            brk2052 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
      if ( ! AV16CalParObl )
      {
         if ( AV32split.size() > 0 )
         {
            AV31r = (short)(1) ;
            AV12auxInvalidas.sort("");
            new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, httpContext.getMessage( "2 &auxInvalidas ", "")+AV12auxInvalidas.toJSonString(false)) ;
            while ( AV31r <= AV12auxInvalidas.size() )
            {
               if ( GXutil.strcmp((String)AV12auxInvalidas.elementAt(-1+AV31r), AV34ultimaInvalida) == 0 )
               {
                  AV12auxInvalidas.removeItem(AV31r);
               }
               else
               {
                  AV34ultimaInvalida = (String)AV12auxInvalidas.elementAt(-1+AV31r) ;
                  AV31r = (short)(AV31r+1) ;
               }
            }
            if ( AV12auxInvalidas.size() == 1 )
            {
               AV22error = httpContext.getMessage( "Parámetro inválido ", "") ;
            }
            else
            {
               AV22error = httpContext.getMessage( "Parámetros inválidos ", "") ;
            }
            AV22error += httpContext.getMessage( "en \"", "") + GXutil.trim( AV36Operando) + "\"" ;
            if ( AV12auxInvalidas.size() > 0 )
            {
               AV22error += ":" ;
            }
            AV22error += " " ;
            AV26i = (short)(1) ;
            while ( AV26i <= AV12auxInvalidas.size() )
            {
               if ( AV26i > 1 )
               {
                  AV22error += ", " ;
               }
               AV22error += GXutil.trim( (String)AV12auxInvalidas.elementAt(-1+AV26i)) ;
               AV26i = (short)(AV26i+1) ;
            }
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = calparvalidayasigna.this.AV32split;
      this.aP6[0] = calparvalidayasigna.this.AV14cal_par_valores;
      this.aP7[0] = calparvalidayasigna.this.AV22error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV22error = "" ;
      AV37auxcal_par_valores = new GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem>(web.Sdtcal_par_valores_cal_par_valoresItem.class, "cal_par_valoresItem", "PayDay", remoteHandle);
      AV40Pgmname = "" ;
      scmdbuf = "" ;
      P02052_A46PaiCod = new short[1] ;
      P02052_A74idOperando = new String[] {""} ;
      P02052_A2106CalParObl = new boolean[] {false} ;
      P02052_A2098CalParId = new String[] {""} ;
      P02052_A2110CalParNombre = new String[] {""} ;
      P02052_A2111CalParValLista = new String[] {""} ;
      P02052_A2104CalParGrp = new byte[1] ;
      A74idOperando = "" ;
      A2098CalParId = "" ;
      A2110CalParNombre = "" ;
      A2111CalParValLista = "" ;
      AV8aux2Error = "" ;
      AV28item = new web.Sdtcal_par_valores_cal_par_valoresItem(remoteHandle, context);
      GXv_Sdtcal_par_valores_cal_par_valoresItem1 = new web.Sdtcal_par_valores_cal_par_valoresItem[1] ;
      GXv_objcol_char2 = new GXSimpleCollection[1] ;
      AV11auxError = "" ;
      GXv_char3 = new String[1] ;
      AV12auxInvalidas = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_char4 = new GXSimpleCollection[1] ;
      AV10auxBien = "" ;
      AV34ultimaInvalida = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.calparvalidayasigna__default(),
         new Object[] {
             new Object[] {
            P02052_A46PaiCod, P02052_A74idOperando, P02052_A2106CalParObl, P02052_A2098CalParId, P02052_A2110CalParNombre, P02052_A2111CalParValLista, P02052_A2104CalParGrp
            }
         }
      );
      AV40Pgmname = "CalParValidaYAsigna" ;
      /* GeneXus formulas. */
      AV40Pgmname = "CalParValidaYAsigna" ;
      Gx_err = (short)(0) ;
   }

   private byte A2104CalParGrp ;
   private short AV29PaiCod ;
   private short A46PaiCod ;
   private short AV17cant ;
   private short AV23errorCant ;
   private short AV13bienCant ;
   private short AV31r ;
   private short AV26i ;
   private short Gx_err ;
   private int AV18CliCod ;
   private int AV43GXV1 ;
   private String AV27idOperando ;
   private String AV40Pgmname ;
   private String scmdbuf ;
   private String A74idOperando ;
   private String A2098CalParId ;
   private String GXv_char3[] ;
   private String AV34ultimaInvalida ;
   private boolean AV16CalParObl ;
   private boolean brk2052 ;
   private boolean A2106CalParObl ;
   private boolean AV25hay ;
   private boolean returnInSub ;
   private String AV36Operando ;
   private String AV22error ;
   private String A2110CalParNombre ;
   private String A2111CalParValLista ;
   private String AV8aux2Error ;
   private String AV11auxError ;
   private String AV10auxBien ;
   private String[] aP7 ;
   private GXSimpleCollection<String>[] aP5 ;
   private GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem>[] aP6 ;
   private IDataStoreProvider pr_default ;
   private short[] P02052_A46PaiCod ;
   private String[] P02052_A74idOperando ;
   private boolean[] P02052_A2106CalParObl ;
   private String[] P02052_A2098CalParId ;
   private String[] P02052_A2110CalParNombre ;
   private String[] P02052_A2111CalParValLista ;
   private byte[] P02052_A2104CalParGrp ;
   private GXSimpleCollection<String> AV32split ;
   private GXSimpleCollection<String> GXv_objcol_char2[] ;
   private GXSimpleCollection<String> AV12auxInvalidas ;
   private GXSimpleCollection<String> GXv_objcol_char4[] ;
   private GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem> AV14cal_par_valores ;
   private GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem> AV37auxcal_par_valores ;
   private web.Sdtcal_par_valores_cal_par_valoresItem AV28item ;
   private web.Sdtcal_par_valores_cal_par_valoresItem GXv_Sdtcal_par_valores_cal_par_valoresItem1[] ;
}

final  class calparvalidayasigna__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02052", "SELECT PaiCod, idOperando, CalParObl, CalParId, CalParNombre, CalParValLista, CalParGrp FROM Calculo_parametros WHERE (PaiCod = ? and idOperando = ( ?)) AND (CalParObl = ?) ORDER BY PaiCod, idOperando, CalParGrp, CalParValLista DESC ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               return;
      }
   }

}

