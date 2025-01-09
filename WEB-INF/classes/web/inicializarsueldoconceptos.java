package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class inicializarsueldoconceptos extends GXProcedure
{
   public inicializarsueldoconceptos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( inicializarsueldoconceptos.class ), "" );
   }

   public inicializarsueldoconceptos( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        java.util.Date aP1 ,
                        java.util.Date aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             java.util.Date aP1 ,
                             java.util.Date aP2 )
   {
      inicializarsueldoconceptos.this.AV11CliCod = aP0;
      inicializarsueldoconceptos.this.AV12desdeFecha = aP1;
      inicializarsueldoconceptos.this.AV13proximaFecha = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV21Pgmname, "1") ;
      /* Using cursor P02CT2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P02CT2_A3CliCod[0] ;
         A1EmpCod = P02CT2_A1EmpCod[0] ;
         A6LegNumero = P02CT2_A6LegNumero[0] ;
         AV16item = (web.Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem)new web.Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem(remoteHandle, context);
         AV16item.setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Empcod( A1EmpCod );
         AV16item.setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legnumero( A6LegNumero );
         AV15sdt_legajo_sueldos.add(AV16item, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV23GXV1 = 1 ;
      while ( AV23GXV1 <= AV15sdt_legajo_sueldos.size() )
      {
         AV16item = (web.Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem)((web.Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem)AV15sdt_legajo_sueldos.elementAt(-1+AV23GXV1));
         new web.recalcularlegsuelbasicaporlegupd(remoteHandle, context).execute( (short)(0), AV11CliCod, AV16item.getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Empcod(), AV16item.getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legnumero(), "") ;
         AV23GXV1 = (int)(AV23GXV1+1) ;
      }
      AV15sdt_legajo_sueldos.clear();
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           AV13proximaFecha ,
                                           A1136LegSuelFecha ,
                                           AV12desdeFecha ,
                                           Boolean.valueOf(A2357LegSuelBasica) ,
                                           Integer.valueOf(AV11CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      /* Using cursor P02CT3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV11CliCod), AV12desdeFecha, AV13proximaFecha});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A2357LegSuelBasica = P02CT3_A2357LegSuelBasica[0] ;
         A1136LegSuelFecha = P02CT3_A1136LegSuelFecha[0] ;
         A3CliCod = P02CT3_A3CliCod[0] ;
         A1EmpCod = P02CT3_A1EmpCod[0] ;
         A6LegNumero = P02CT3_A6LegNumero[0] ;
         A1135LegSuelSec = P02CT3_A1135LegSuelSec[0] ;
         A1137LegSuelImporte = P02CT3_A1137LegSuelImporte[0] ;
         A2344LegSuelTipo = P02CT3_A2344LegSuelTipo[0] ;
         n2344LegSuelTipo = P02CT3_n2344LegSuelTipo[0] ;
         AV16item = (web.Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem)new web.Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem(remoteHandle, context);
         AV16item.setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Empcod( A1EmpCod );
         AV16item.setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legnumero( A6LegNumero );
         AV16item.setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelsec( A1135LegSuelSec );
         AV16item.setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha( A1136LegSuelFecha );
         AV16item.setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelimporte( A1137LegSuelImporte );
         AV16item.setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsueltipo( A2344LegSuelTipo );
         AV15sdt_legajo_sueldos.add(AV16item, 0);
         pr_default.readNext(1);
      }
      pr_default.close(1);
      new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV21Pgmname, httpContext.getMessage( "&sdt_legajo_sueldos ", "")+AV15sdt_legajo_sueldos.toJSonString(false)) ;
      AV25GXV2 = 1 ;
      while ( AV25GXV2 <= AV15sdt_legajo_sueldos.size() )
      {
         AV16item = (web.Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem)((web.Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem)AV15sdt_legajo_sueldos.elementAt(-1+AV25GXV2));
         new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV21Pgmname, httpContext.getMessage( "emp ", "")+GXutil.trim( GXutil.str( AV16item.getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Empcod(), 4, 0))+httpContext.getMessage( " leg ", "")+GXutil.trim( GXutil.str( AV16item.getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legnumero(), 8, 0))) ;
         GXv_decimal1[0] = AV18LegSuelCalc ;
         GXv_char2[0] = AV17LegSuelLog ;
         new web.leyendaaclaracionsueldo(remoteHandle, context).execute( AV11CliCod, AV16item.getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Empcod(), AV16item.getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legnumero(), AV16item.getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsueltipo(), AV16item.getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha(), AV16item.getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelsec(), AV16item.getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelimporte(), false, false, "", true, false, GXv_decimal1, GXv_char2) ;
         inicializarsueldoconceptos.this.AV18LegSuelCalc = GXv_decimal1[0] ;
         inicializarsueldoconceptos.this.AV17LegSuelLog = GXv_char2[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV21Pgmname, httpContext.getMessage( "llama a legajoSueldoSetCalcYTxt con ", "")+GXutil.trim( GXutil.str( AV18LegSuelCalc, 14, 2))+httpContext.getMessage( " &LegSuelLog ", "")+GXutil.trim( AV17LegSuelLog)) ;
         AV25GXV2 = (int)(AV25GXV2+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV21Pgmname = "" ;
      scmdbuf = "" ;
      P02CT2_A3CliCod = new int[1] ;
      P02CT2_A1EmpCod = new short[1] ;
      P02CT2_A6LegNumero = new int[1] ;
      AV16item = new web.Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem(remoteHandle, context);
      AV15sdt_legajo_sueldos = new GXBaseCollection<web.Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem>(web.Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem.class, "sdt_legajo_sueldosItem", "PayDay", remoteHandle);
      A1136LegSuelFecha = GXutil.nullDate() ;
      P02CT3_A2357LegSuelBasica = new boolean[] {false} ;
      P02CT3_A1136LegSuelFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P02CT3_A3CliCod = new int[1] ;
      P02CT3_A1EmpCod = new short[1] ;
      P02CT3_A6LegNumero = new int[1] ;
      P02CT3_A1135LegSuelSec = new short[1] ;
      P02CT3_A1137LegSuelImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02CT3_A2344LegSuelTipo = new String[] {""} ;
      P02CT3_n2344LegSuelTipo = new boolean[] {false} ;
      A1137LegSuelImporte = DecimalUtil.ZERO ;
      A2344LegSuelTipo = "" ;
      AV18LegSuelCalc = DecimalUtil.ZERO ;
      GXv_decimal1 = new java.math.BigDecimal[1] ;
      AV17LegSuelLog = "" ;
      GXv_char2 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.inicializarsueldoconceptos__default(),
         new Object[] {
             new Object[] {
            P02CT2_A3CliCod, P02CT2_A1EmpCod, P02CT2_A6LegNumero
            }
            , new Object[] {
            P02CT3_A2357LegSuelBasica, P02CT3_A1136LegSuelFecha, P02CT3_A3CliCod, P02CT3_A1EmpCod, P02CT3_A6LegNumero, P02CT3_A1135LegSuelSec, P02CT3_A1137LegSuelImporte, P02CT3_A2344LegSuelTipo, P02CT3_n2344LegSuelTipo
            }
         }
      );
      AV21Pgmname = "inicializarSueldoConceptos" ;
      /* GeneXus formulas. */
      AV21Pgmname = "inicializarSueldoConceptos" ;
      Gx_err = (short)(0) ;
   }

   private short A1EmpCod ;
   private short A1135LegSuelSec ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int AV23GXV1 ;
   private int AV25GXV2 ;
   private java.math.BigDecimal A1137LegSuelImporte ;
   private java.math.BigDecimal AV18LegSuelCalc ;
   private java.math.BigDecimal GXv_decimal1[] ;
   private String AV21Pgmname ;
   private String scmdbuf ;
   private String A2344LegSuelTipo ;
   private String GXv_char2[] ;
   private java.util.Date AV12desdeFecha ;
   private java.util.Date AV13proximaFecha ;
   private java.util.Date A1136LegSuelFecha ;
   private boolean A2357LegSuelBasica ;
   private boolean n2344LegSuelTipo ;
   private String AV17LegSuelLog ;
   private IDataStoreProvider pr_default ;
   private int[] P02CT2_A3CliCod ;
   private short[] P02CT2_A1EmpCod ;
   private int[] P02CT2_A6LegNumero ;
   private boolean[] P02CT3_A2357LegSuelBasica ;
   private java.util.Date[] P02CT3_A1136LegSuelFecha ;
   private int[] P02CT3_A3CliCod ;
   private short[] P02CT3_A1EmpCod ;
   private int[] P02CT3_A6LegNumero ;
   private short[] P02CT3_A1135LegSuelSec ;
   private java.math.BigDecimal[] P02CT3_A1137LegSuelImporte ;
   private String[] P02CT3_A2344LegSuelTipo ;
   private boolean[] P02CT3_n2344LegSuelTipo ;
   private GXBaseCollection<web.Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem> AV15sdt_legajo_sueldos ;
   private web.Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem AV16item ;
}

final  class inicializarsueldoconceptos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02CT3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          java.util.Date AV13proximaFecha ,
                                          java.util.Date A1136LegSuelFecha ,
                                          java.util.Date AV12desdeFecha ,
                                          boolean A2357LegSuelBasica ,
                                          int AV11CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int3 = new byte[3];
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT LegSuelBasica, LegSuelFecha, CliCod, EmpCod, LegNumero, LegSuelSec, LegSuelImporte, LegSuelTipo FROM legajo_sueldos" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(LegSuelFecha >= ?)");
      addWhere(sWhereString, "(LegSuelBasica = TRUE)");
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV13proximaFecha)) )
      {
         addWhere(sWhereString, "(LegSuelFecha < ?)");
      }
      else
      {
         GXv_int3[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod" ;
      GXv_Object4[0] = scmdbuf ;
      GXv_Object4[1] = GXv_int3 ;
      return GXv_Object4 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 1 :
                  return conditional_P02CT3(context, remoteHandle, httpContext, (java.util.Date)dynConstraints[0] , (java.util.Date)dynConstraints[1] , (java.util.Date)dynConstraints[2] , ((Boolean) dynConstraints[3]).booleanValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02CT2", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02CT3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 1 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[4]);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[5]);
               }
               return;
      }
   }

}

