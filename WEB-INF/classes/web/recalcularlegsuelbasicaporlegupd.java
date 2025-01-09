package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class recalcularlegsuelbasicaporlegupd extends GXProcedure
{
   public recalcularlegsuelbasicaporlegupd( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( recalcularlegsuelbasicaporlegupd.class ), "" );
   }

   public recalcularlegsuelbasicaporlegupd( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( short aP0 ,
                        int aP1 ,
                        short aP2 ,
                        int aP3 ,
                        String aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( short aP0 ,
                             int aP1 ,
                             short aP2 ,
                             int aP3 ,
                             String aP4 )
   {
      recalcularlegsuelbasicaporlegupd.this.AV23CliPaiCod = aP0;
      recalcularlegsuelbasicaporlegupd.this.AV10CliCod = aP1;
      recalcularlegsuelbasicaporlegupd.this.AV11EmpCod = aP2;
      recalcularlegsuelbasicaporlegupd.this.AV19parmLegNumero = aP3;
      recalcularlegsuelbasicaporlegupd.this.AV18trnPalabra = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV27Pgmname, "1") ;
      GXt_char1 = AV17mensualTLiqCod ;
      GXt_char2 = AV17mensualTLiqCod ;
      GXv_char3[0] = GXt_char2 ;
      new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      recalcularlegsuelbasicaporlegupd.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char2, GXv_char4) ;
      recalcularlegsuelbasicaporlegupd.this.GXt_char1 = GXv_char4[0] ;
      AV17mensualTLiqCod = GXt_char1 ;
      if ( ! (0==AV10CliCod) )
      {
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              Integer.valueOf(AV19parmLegNumero) ,
                                              Integer.valueOf(A6LegNumero) ,
                                              Integer.valueOf(AV10CliCod) ,
                                              Short.valueOf(AV11EmpCod) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) } ,
                                              new int[]{
                                              TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                              }
         });
         /* Using cursor P02CG2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV19parmLegNumero)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A6LegNumero = P02CG2_A6LegNumero[0] ;
            A1EmpCod = P02CG2_A1EmpCod[0] ;
            A3CliCod = P02CG2_A3CliCod[0] ;
            A1135LegSuelSec = P02CG2_A1135LegSuelSec[0] ;
            A1136LegSuelFecha = P02CG2_A1136LegSuelFecha[0] ;
            AV21item = (web.Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem)new web.Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem(remoteHandle, context);
            AV21item.setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Clicod( A3CliCod );
            AV21item.setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Empcod( A1EmpCod );
            AV21item.setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legnumero( A6LegNumero );
            AV21item.setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelsec( A1135LegSuelSec );
            AV21item.setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha( A1136LegSuelFecha );
            AV20sdt_legajo_sueldos.add(AV21item, 0);
            pr_default.readNext(0);
         }
         pr_default.close(0);
      }
      else
      {
         /* Using cursor P02CG3 */
         pr_default.execute(1, new Object[] {Short.valueOf(AV23CliPaiCod)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A4CliPaiCod = P02CG3_A4CliPaiCod[0] ;
            n4CliPaiCod = P02CG3_n4CliPaiCod[0] ;
            A3CliCod = P02CG3_A3CliCod[0] ;
            AV22auxCliCod = A3CliCod ;
            /* Using cursor P02CG4 */
            pr_default.execute(2, new Object[] {Integer.valueOf(AV22auxCliCod)});
            while ( (pr_default.getStatus(2) != 101) )
            {
               A3CliCod = P02CG4_A3CliCod[0] ;
               A1EmpCod = P02CG4_A1EmpCod[0] ;
               A6LegNumero = P02CG4_A6LegNumero[0] ;
               A1135LegSuelSec = P02CG4_A1135LegSuelSec[0] ;
               A1136LegSuelFecha = P02CG4_A1136LegSuelFecha[0] ;
               AV21item = (web.Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem)new web.Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem(remoteHandle, context);
               AV21item.setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Clicod( A3CliCod );
               AV21item.setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Empcod( A1EmpCod );
               AV21item.setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legnumero( A6LegNumero );
               AV21item.setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelsec( A1135LegSuelSec );
               AV21item.setgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha( A1136LegSuelFecha );
               AV20sdt_legajo_sueldos.add(AV21item, 0);
               pr_default.readNext(2);
            }
            pr_default.close(2);
            pr_default.readNext(1);
         }
         pr_default.close(1);
      }
      AV31GXV1 = 1 ;
      while ( AV31GXV1 <= AV20sdt_legajo_sueldos.size() )
      {
         AV21item = (web.Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem)((web.Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem)AV20sdt_legajo_sueldos.elementAt(-1+AV31GXV1));
         GXv_boolean5[0] = AV9LegSuelBasica ;
         new web.determinalegsuelbasica(remoteHandle, context).execute( AV21item.getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Clicod(), AV21item.getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Empcod(), 0, AV21item.getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legnumero(), AV17mensualTLiqCod, AV21item.getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelfecha(), (short)(0), AV18trnPalabra, GXv_boolean5) ;
         recalcularlegsuelbasicaporlegupd.this.AV9LegSuelBasica = GXv_boolean5[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV27Pgmname, httpContext.getMessage( "&item.LegNumero ", "")+GXutil.trim( GXutil.str( AV21item.getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legnumero(), 8, 0))+httpContext.getMessage( " &LegSuelBasica ", "")+GXutil.trim( GXutil.booltostr( AV9LegSuelBasica))) ;
         new web.setlegsuelbasica(remoteHandle, context).execute( AV21item.getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Clicod(), AV21item.getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Empcod(), AV21item.getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legnumero(), AV21item.getgxTv_Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem_Legsuelsec(), AV9LegSuelBasica) ;
         AV31GXV1 = (int)(AV31GXV1+1) ;
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
      AV27Pgmname = "" ;
      AV17mensualTLiqCod = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      GXv_char4 = new String[1] ;
      scmdbuf = "" ;
      P02CG2_A6LegNumero = new int[1] ;
      P02CG2_A1EmpCod = new short[1] ;
      P02CG2_A3CliCod = new int[1] ;
      P02CG2_A1135LegSuelSec = new short[1] ;
      P02CG2_A1136LegSuelFecha = new java.util.Date[] {GXutil.nullDate()} ;
      A1136LegSuelFecha = GXutil.nullDate() ;
      AV21item = new web.Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem(remoteHandle, context);
      AV20sdt_legajo_sueldos = new GXBaseCollection<web.Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem>(web.Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem.class, "sdt_legajo_sueldosItem", "PayDay", remoteHandle);
      P02CG3_A4CliPaiCod = new short[1] ;
      P02CG3_n4CliPaiCod = new boolean[] {false} ;
      P02CG3_A3CliCod = new int[1] ;
      P02CG4_A3CliCod = new int[1] ;
      P02CG4_A1EmpCod = new short[1] ;
      P02CG4_A6LegNumero = new int[1] ;
      P02CG4_A1135LegSuelSec = new short[1] ;
      P02CG4_A1136LegSuelFecha = new java.util.Date[] {GXutil.nullDate()} ;
      GXv_boolean5 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.recalcularlegsuelbasicaporlegupd__default(),
         new Object[] {
             new Object[] {
            P02CG2_A6LegNumero, P02CG2_A1EmpCod, P02CG2_A3CliCod, P02CG2_A1135LegSuelSec, P02CG2_A1136LegSuelFecha
            }
            , new Object[] {
            P02CG3_A4CliPaiCod, P02CG3_n4CliPaiCod, P02CG3_A3CliCod
            }
            , new Object[] {
            P02CG4_A3CliCod, P02CG4_A1EmpCod, P02CG4_A6LegNumero, P02CG4_A1135LegSuelSec, P02CG4_A1136LegSuelFecha
            }
         }
      );
      AV27Pgmname = "reCalcularLegSuelBasicaPorLegUPD" ;
      /* GeneXus formulas. */
      AV27Pgmname = "reCalcularLegSuelBasicaPorLegUPD" ;
      Gx_err = (short)(0) ;
   }

   private short AV23CliPaiCod ;
   private short AV11EmpCod ;
   private short A1EmpCod ;
   private short A1135LegSuelSec ;
   private short A4CliPaiCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV19parmLegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int AV22auxCliCod ;
   private int AV31GXV1 ;
   private String AV18trnPalabra ;
   private String AV27Pgmname ;
   private String AV17mensualTLiqCod ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private String scmdbuf ;
   private java.util.Date A1136LegSuelFecha ;
   private boolean n4CliPaiCod ;
   private boolean AV9LegSuelBasica ;
   private boolean GXv_boolean5[] ;
   private IDataStoreProvider pr_default ;
   private int[] P02CG2_A6LegNumero ;
   private short[] P02CG2_A1EmpCod ;
   private int[] P02CG2_A3CliCod ;
   private short[] P02CG2_A1135LegSuelSec ;
   private java.util.Date[] P02CG2_A1136LegSuelFecha ;
   private short[] P02CG3_A4CliPaiCod ;
   private boolean[] P02CG3_n4CliPaiCod ;
   private int[] P02CG3_A3CliCod ;
   private int[] P02CG4_A3CliCod ;
   private short[] P02CG4_A1EmpCod ;
   private int[] P02CG4_A6LegNumero ;
   private short[] P02CG4_A1135LegSuelSec ;
   private java.util.Date[] P02CG4_A1136LegSuelFecha ;
   private GXBaseCollection<web.Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem> AV20sdt_legajo_sueldos ;
   private web.Sdtsdt_legajo_sueldos_sdt_legajo_sueldosItem AV21item ;
}

final  class recalcularlegsuelbasicaporlegupd__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02CG2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV19parmLegNumero ,
                                          int A6LegNumero ,
                                          int AV10CliCod ,
                                          short AV11EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[3];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT LegNumero, EmpCod, CliCod, LegSuelSec, LegSuelFecha FROM legajo_sueldos" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( ! (0==AV19parmLegNumero) )
      {
         addWhere(sWhereString, "(LegNumero = ?)");
      }
      else
      {
         GXv_int6[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod" ;
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P02CG2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02CG2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02CG3", "SELECT CliPaiCod, CliCod FROM Cliente WHERE CliPaiCod = ? ORDER BY CliPaiCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02CG4", "SELECT CliCod, EmpCod, LegNumero, LegSuelSec, LegSuelFecha FROM legajo_sueldos WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
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
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[4]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

