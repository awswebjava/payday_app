package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conveniosdesindicatocoleccion extends GXProcedure
{
   public conveniosdesindicatocoleccion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conveniosdesindicatocoleccion.class ), "" );
   }

   public conveniosdesindicatocoleccion( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.Sdtsdt_convenios_sdt_conveniosItem> executeUdp( int aP0 ,
                                                                               short aP1 ,
                                                                               String aP2 )
   {
      conveniosdesindicatocoleccion.this.aP3 = new GXBaseCollection[] {new GXBaseCollection<web.Sdtsdt_convenios_sdt_conveniosItem>()};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        GXBaseCollection<web.Sdtsdt_convenios_sdt_conveniosItem>[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             GXBaseCollection<web.Sdtsdt_convenios_sdt_conveniosItem>[] aP3 )
   {
      conveniosdesindicatocoleccion.this.AV11CliCod = aP0;
      conveniosdesindicatocoleccion.this.AV12EmpCod = aP1;
      conveniosdesindicatocoleccion.this.AV8SinCod = aP2;
      conveniosdesindicatocoleccion.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV15PaiCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getpaicod(remoteHandle, context).execute( AV11CliCod, GXv_int2) ;
      conveniosdesindicatocoleccion.this.GXt_int1 = GXv_int2[0] ;
      AV15PaiCod = GXt_int1 ;
      if ( ! (GXutil.strcmp("", AV8SinCod)==0) )
      {
         /* Using cursor P00YJ2 */
         pr_default.execute(0, new Object[] {Short.valueOf(AV15PaiCod), AV8SinCod});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A46PaiCod = P00YJ2_A46PaiCod[0] ;
            A935ConveSinCod = P00YJ2_A935ConveSinCod[0] ;
            n935ConveSinCod = P00YJ2_n935ConveSinCod[0] ;
            A2428ConveEsquemaEs = P00YJ2_A2428ConveEsquemaEs[0] ;
            A9ConveCodigo = P00YJ2_A9ConveCodigo[0] ;
            A160ConveDescri = P00YJ2_A160ConveDescri[0] ;
            /* Using cursor P00YJ3 */
            pr_default.execute(1, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV15PaiCod), A9ConveCodigo});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A1565CliConvenio = P00YJ3_A1565CliConvenio[0] ;
               A1564CliPaiConve = P00YJ3_A1564CliPaiConve[0] ;
               A3CliCod = P00YJ3_A3CliCod[0] ;
               A1567CliConvenioDescrip = P00YJ3_A1567CliConvenioDescrip[0] ;
               A1567CliConvenioDescrip = P00YJ3_A1567CliConvenioDescrip[0] ;
               AV14itemSdt_Convenios = (web.Sdtsdt_convenios_sdt_conveniosItem)new web.Sdtsdt_convenios_sdt_conveniosItem(remoteHandle, context);
               AV14itemSdt_Convenios.setgxTv_Sdtsdt_convenios_sdt_conveniosItem_Convecodigo( A1565CliConvenio );
               AV14itemSdt_Convenios.setgxTv_Sdtsdt_convenios_sdt_conveniosItem_Convedescri( GXutil.trim( A1567CliConvenioDescrip)+httpContext.getMessage( " (CCT)", "") );
               AV13sdt_convenios.add(AV14itemSdt_Convenios, 0);
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(1);
            pr_default.readNext(0);
         }
         pr_default.close(0);
      }
      else
      {
         GXv_objcol_char3[0] = AV10sindicatos ;
         new web.getsindicatosactividadempresa(remoteHandle, context).execute( AV11CliCod, AV12EmpCod, GXv_objcol_char3) ;
         AV10sindicatos = GXv_objcol_char3[0] ;
         pr_default.dynParam(2, new Object[]{ new Object[]{
                                              A935ConveSinCod ,
                                              AV10sindicatos ,
                                              Boolean.valueOf(A2428ConveEsquemaEs) ,
                                              Short.valueOf(AV15PaiCod) ,
                                              Short.valueOf(A46PaiCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT
                                              }
         });
         /* Using cursor P00YJ4 */
         pr_default.execute(2, new Object[] {Short.valueOf(AV15PaiCod)});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A46PaiCod = P00YJ4_A46PaiCod[0] ;
            A2428ConveEsquemaEs = P00YJ4_A2428ConveEsquemaEs[0] ;
            A9ConveCodigo = P00YJ4_A9ConveCodigo[0] ;
            A935ConveSinCod = P00YJ4_A935ConveSinCod[0] ;
            n935ConveSinCod = P00YJ4_n935ConveSinCod[0] ;
            A160ConveDescri = P00YJ4_A160ConveDescri[0] ;
            /* Using cursor P00YJ5 */
            pr_default.execute(3, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV15PaiCod), A9ConveCodigo});
            while ( (pr_default.getStatus(3) != 101) )
            {
               A1565CliConvenio = P00YJ5_A1565CliConvenio[0] ;
               A1564CliPaiConve = P00YJ5_A1564CliPaiConve[0] ;
               A3CliCod = P00YJ5_A3CliCod[0] ;
               A1567CliConvenioDescrip = P00YJ5_A1567CliConvenioDescrip[0] ;
               A1567CliConvenioDescrip = P00YJ5_A1567CliConvenioDescrip[0] ;
               AV14itemSdt_Convenios = (web.Sdtsdt_convenios_sdt_conveniosItem)new web.Sdtsdt_convenios_sdt_conveniosItem(remoteHandle, context);
               AV14itemSdt_Convenios.setgxTv_Sdtsdt_convenios_sdt_conveniosItem_Convecodigo( A1565CliConvenio );
               AV14itemSdt_Convenios.setgxTv_Sdtsdt_convenios_sdt_conveniosItem_Convedescri( GXutil.trim( A1567CliConvenioDescrip)+httpContext.getMessage( " (CCT)", "") );
               AV13sdt_convenios.add(AV14itemSdt_Convenios, 0);
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(3);
            pr_default.readNext(2);
         }
         pr_default.close(2);
      }
      /* Using cursor P00YJ6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV15PaiCod)});
      while ( (pr_default.getStatus(4) != 101) )
      {
         A2429CliConveEsquemaEs = P00YJ6_A2429CliConveEsquemaEs[0] ;
         A1564CliPaiConve = P00YJ6_A1564CliPaiConve[0] ;
         A3CliCod = P00YJ6_A3CliCod[0] ;
         A1565CliConvenio = P00YJ6_A1565CliConvenio[0] ;
         A1567CliConvenioDescrip = P00YJ6_A1567CliConvenioDescrip[0] ;
         A1567CliConvenioDescrip = P00YJ6_A1567CliConvenioDescrip[0] ;
         AV14itemSdt_Convenios = (web.Sdtsdt_convenios_sdt_conveniosItem)new web.Sdtsdt_convenios_sdt_conveniosItem(remoteHandle, context);
         AV14itemSdt_Convenios.setgxTv_Sdtsdt_convenios_sdt_conveniosItem_Convecodigo( A1565CliConvenio );
         AV14itemSdt_Convenios.setgxTv_Sdtsdt_convenios_sdt_conveniosItem_Convedescri( GXutil.trim( A1567CliConvenioDescrip)+httpContext.getMessage( " (particular)", "") );
         AV13sdt_convenios.add(AV14itemSdt_Convenios, 0);
         pr_default.readNext(4);
      }
      pr_default.close(4);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = conveniosdesindicatocoleccion.this.AV13sdt_convenios;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13sdt_convenios = new GXBaseCollection<web.Sdtsdt_convenios_sdt_conveniosItem>(web.Sdtsdt_convenios_sdt_conveniosItem.class, "sdt_conveniosItem", "PayDay", remoteHandle);
      GXv_int2 = new short[1] ;
      scmdbuf = "" ;
      P00YJ2_A46PaiCod = new short[1] ;
      P00YJ2_A935ConveSinCod = new String[] {""} ;
      P00YJ2_n935ConveSinCod = new boolean[] {false} ;
      P00YJ2_A2428ConveEsquemaEs = new boolean[] {false} ;
      P00YJ2_A9ConveCodigo = new String[] {""} ;
      P00YJ2_A160ConveDescri = new String[] {""} ;
      A935ConveSinCod = "" ;
      A9ConveCodigo = "" ;
      A160ConveDescri = "" ;
      P00YJ3_A1565CliConvenio = new String[] {""} ;
      P00YJ3_A1564CliPaiConve = new short[1] ;
      P00YJ3_A3CliCod = new int[1] ;
      P00YJ3_A1567CliConvenioDescrip = new String[] {""} ;
      A1565CliConvenio = "" ;
      A1567CliConvenioDescrip = "" ;
      AV14itemSdt_Convenios = new web.Sdtsdt_convenios_sdt_conveniosItem(remoteHandle, context);
      AV10sindicatos = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_char3 = new GXSimpleCollection[1] ;
      P00YJ4_A46PaiCod = new short[1] ;
      P00YJ4_A2428ConveEsquemaEs = new boolean[] {false} ;
      P00YJ4_A9ConveCodigo = new String[] {""} ;
      P00YJ4_A935ConveSinCod = new String[] {""} ;
      P00YJ4_n935ConveSinCod = new boolean[] {false} ;
      P00YJ4_A160ConveDescri = new String[] {""} ;
      P00YJ5_A1565CliConvenio = new String[] {""} ;
      P00YJ5_A1564CliPaiConve = new short[1] ;
      P00YJ5_A3CliCod = new int[1] ;
      P00YJ5_A1567CliConvenioDescrip = new String[] {""} ;
      P00YJ6_A2429CliConveEsquemaEs = new boolean[] {false} ;
      P00YJ6_A1564CliPaiConve = new short[1] ;
      P00YJ6_A3CliCod = new int[1] ;
      P00YJ6_A1565CliConvenio = new String[] {""} ;
      P00YJ6_A1567CliConvenioDescrip = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conveniosdesindicatocoleccion__default(),
         new Object[] {
             new Object[] {
            P00YJ2_A46PaiCod, P00YJ2_A935ConveSinCod, P00YJ2_n935ConveSinCod, P00YJ2_A2428ConveEsquemaEs, P00YJ2_A9ConveCodigo, P00YJ2_A160ConveDescri
            }
            , new Object[] {
            P00YJ3_A1565CliConvenio, P00YJ3_A1564CliPaiConve, P00YJ3_A3CliCod, P00YJ3_A1567CliConvenioDescrip
            }
            , new Object[] {
            P00YJ4_A46PaiCod, P00YJ4_A2428ConveEsquemaEs, P00YJ4_A9ConveCodigo, P00YJ4_A935ConveSinCod, P00YJ4_n935ConveSinCod, P00YJ4_A160ConveDescri
            }
            , new Object[] {
            P00YJ5_A1565CliConvenio, P00YJ5_A1564CliPaiConve, P00YJ5_A3CliCod, P00YJ5_A1567CliConvenioDescrip
            }
            , new Object[] {
            P00YJ6_A2429CliConveEsquemaEs, P00YJ6_A1564CliPaiConve, P00YJ6_A3CliCod, P00YJ6_A1565CliConvenio, P00YJ6_A1567CliConvenioDescrip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12EmpCod ;
   private short AV15PaiCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A46PaiCod ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int A3CliCod ;
   private String AV8SinCod ;
   private String scmdbuf ;
   private String A935ConveSinCod ;
   private String A9ConveCodigo ;
   private String A1565CliConvenio ;
   private boolean n935ConveSinCod ;
   private boolean A2428ConveEsquemaEs ;
   private boolean A2429CliConveEsquemaEs ;
   private String A160ConveDescri ;
   private String A1567CliConvenioDescrip ;
   private GXBaseCollection<web.Sdtsdt_convenios_sdt_conveniosItem>[] aP3 ;
   private IDataStoreProvider pr_default ;
   private short[] P00YJ2_A46PaiCod ;
   private String[] P00YJ2_A935ConveSinCod ;
   private boolean[] P00YJ2_n935ConveSinCod ;
   private boolean[] P00YJ2_A2428ConveEsquemaEs ;
   private String[] P00YJ2_A9ConveCodigo ;
   private String[] P00YJ2_A160ConveDescri ;
   private String[] P00YJ3_A1565CliConvenio ;
   private short[] P00YJ3_A1564CliPaiConve ;
   private int[] P00YJ3_A3CliCod ;
   private String[] P00YJ3_A1567CliConvenioDescrip ;
   private short[] P00YJ4_A46PaiCod ;
   private boolean[] P00YJ4_A2428ConveEsquemaEs ;
   private String[] P00YJ4_A9ConveCodigo ;
   private String[] P00YJ4_A935ConveSinCod ;
   private boolean[] P00YJ4_n935ConveSinCod ;
   private String[] P00YJ4_A160ConveDescri ;
   private String[] P00YJ5_A1565CliConvenio ;
   private short[] P00YJ5_A1564CliPaiConve ;
   private int[] P00YJ5_A3CliCod ;
   private String[] P00YJ5_A1567CliConvenioDescrip ;
   private boolean[] P00YJ6_A2429CliConveEsquemaEs ;
   private short[] P00YJ6_A1564CliPaiConve ;
   private int[] P00YJ6_A3CliCod ;
   private String[] P00YJ6_A1565CliConvenio ;
   private String[] P00YJ6_A1567CliConvenioDescrip ;
   private GXSimpleCollection<String> AV10sindicatos ;
   private GXSimpleCollection<String> GXv_objcol_char3[] ;
   private GXBaseCollection<web.Sdtsdt_convenios_sdt_conveniosItem> AV13sdt_convenios ;
   private web.Sdtsdt_convenios_sdt_conveniosItem AV14itemSdt_Convenios ;
}

final  class conveniosdesindicatocoleccion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00YJ4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A935ConveSinCod ,
                                          GXSimpleCollection<String> AV10sindicatos ,
                                          boolean A2428ConveEsquemaEs ,
                                          short AV15PaiCod ,
                                          short A46PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[1];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT PaiCod, ConveEsquemaEs, ConveCodigo, ConveSinCod, ConveDescri FROM Convenio" ;
      addWhere(sWhereString, "(PaiCod = ?)");
      addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV10sindicatos, "ConveSinCod IN (", ")")+")");
      addWhere(sWhereString, "(ConveEsquemaEs = FALSE)");
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PaiCod, ConveDescri" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 2 :
                  return conditional_P00YJ4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Boolean) dynConstraints[2]).booleanValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00YJ2", "SELECT PaiCod, ConveSinCod, ConveEsquemaEs, ConveCodigo, ConveDescri FROM Convenio WHERE (PaiCod = ? and ConveSinCod = ( ?)) AND (ConveEsquemaEs = FALSE) ORDER BY PaiCod, ConveSinCod, ConveDescri ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00YJ3", "SELECT T1.CliConvenio AS CliConvenio, T1.CliPaiConve AS CliPaiConve, T1.CliCod, T2.ConveDescri AS CliConvenioDescrip FROM (ClienteConvenios T1 INNER JOIN Convenio T2 ON T2.PaiCod = T1.CliPaiConve AND T2.ConveCodigo = T1.CliConvenio) WHERE T1.CliCod = ? and T1.CliPaiConve = ? and T1.CliConvenio = ( ?) ORDER BY T1.CliCod, T1.CliPaiConve, T1.CliConvenio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00YJ4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00YJ5", "SELECT T1.CliConvenio AS CliConvenio, T1.CliPaiConve AS CliPaiConve, T1.CliCod, T2.ConveDescri AS CliConvenioDescrip FROM (ClienteConvenios T1 INNER JOIN Convenio T2 ON T2.PaiCod = T1.CliPaiConve AND T2.ConveCodigo = T1.CliConvenio) WHERE T1.CliCod = ? and T1.CliPaiConve = ? and T1.CliConvenio = ( ?) ORDER BY T1.CliCod, T1.CliPaiConve, T1.CliConvenio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00YJ6", "SELECT T1.CliConveEsquemaEs, T1.CliPaiConve AS CliPaiConve, T1.CliCod, T1.CliConvenio AS CliConvenio, T2.ConveDescri AS CliConvenioDescrip FROM (ClienteConvenios T1 INNER JOIN Convenio T2 ON T2.PaiCod = T1.CliPaiConve AND T2.ConveCodigo = T1.CliConvenio) WHERE (T1.CliCod = ? and T1.CliPaiConve = ?) AND (T1.CliConveEsquemaEs = TRUE) ORDER BY T1.CliCod, T1.CliPaiConve ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((boolean[]) buf[3])[0] = rslt.getBoolean(3);
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 4 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[1]).shortValue());
               }
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

