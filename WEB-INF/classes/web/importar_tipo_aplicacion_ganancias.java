package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class importar_tipo_aplicacion_ganancias extends GXProcedure
{
   public importar_tipo_aplicacion_ganancias( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importar_tipo_aplicacion_ganancias.class ), "" );
   }

   public importar_tipo_aplicacion_ganancias( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        int aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             int aP1 )
   {
      importar_tipo_aplicacion_ganancias.this.AV8OrigiCliCod = aP0;
      importar_tipo_aplicacion_ganancias.this.AV10CliCod = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P017D2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8OrigiCliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P017D2_A3CliCod[0] ;
         A1121AplIIGGPrrtear = P017D2_A1121AplIIGGPrrtear[0] ;
         A1112AplIIGG = P017D2_A1112AplIIGG[0] ;
         n1112AplIIGG = P017D2_n1112AplIIGG[0] ;
         A1113AplIIGGNom = P017D2_A1113AplIIGGNom[0] ;
         A1114AplIIGGPropor = P017D2_A1114AplIIGGPropor[0] ;
         A1115AplIIGGTopeTip = P017D2_A1115AplIIGGTopeTip[0] ;
         A1109AplIIGGTopeVar = P017D2_A1109AplIIGGTopeVar[0] ;
         n1109AplIIGGTopeVar = P017D2_n1109AplIIGGTopeVar[0] ;
         A1111AplIIGGTopeCon = P017D2_A1111AplIIGGTopeCon[0] ;
         n1111AplIIGGTopeCon = P017D2_n1111AplIIGGTopeCon[0] ;
         A1124AplIIGGCondicion = P017D2_A1124AplIIGGCondicion[0] ;
         n1124AplIIGGCondicion = P017D2_n1124AplIIGGCondicion[0] ;
         A1117AplIIGGExenCon = P017D2_A1117AplIIGGExenCon[0] ;
         n1117AplIIGGExenCon = P017D2_n1117AplIIGGExenCon[0] ;
         A1118ApliIIGGExenOtr = P017D2_A1118ApliIIGGExenOtr[0] ;
         n1118ApliIIGGExenOtr = P017D2_n1118ApliIIGGExenOtr[0] ;
         A1119AplIIGGTopeFij = P017D2_A1119AplIIGGTopeFij[0] ;
         A1120AplIIGGTrat = P017D2_A1120AplIIGGTrat[0] ;
         if ( GXutil.strcmp(A1121AplIIGGPrrtear, "SIN") == 0 )
         {
            AV13auxNum = (short)(0) ;
         }
         else
         {
            if ( GXutil.strcmp(A1121AplIIGGPrrtear, "FIJA") == 0 )
            {
               AV13auxNum = (short)(1) ;
            }
            else
            {
               AV13auxNum = (short)(2) ;
            }
         }
         new web.new_tipo_aplicacion_ganancias(remoteHandle, context).execute( AV10CliCod, A1112AplIIGG, A1113AplIIGGNom, A1114AplIIGGPropor, A1115AplIIGGTopeTip, A1109AplIIGGTopeVar, A1111AplIIGGTopeCon, A1124AplIIGGCondicion, A1117AplIIGGExenCon, A1118ApliIIGGExenOtr, A1119AplIIGGTopeFij, A1120AplIIGGTrat, (byte)(AV13auxNum)) ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      /* Using cursor P017D3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV8OrigiCliCod)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A3CliCod = P017D3_A3CliCod[0] ;
         A1112AplIIGG = P017D3_A1112AplIIGG[0] ;
         n1112AplIIGG = P017D3_n1112AplIIGG[0] ;
         A26ConCodigo = P017D3_A26ConCodigo[0] ;
         AV11AplIIGG = A1112AplIIGG ;
         AV12ConCodigo = A26ConCodigo ;
         /* Execute user subroutine: 'ACTUALIZAR' */
         S111 ();
         if ( returnInSub )
         {
            pr_default.close(1);
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         pr_default.readNext(1);
      }
      pr_default.close(1);
      cleanup();
   }

   public void S111( )
   {
      /* 'ACTUALIZAR' Routine */
      returnInSub = false ;
      /* Using cursor P017D4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV10CliCod), AV12ConCodigo});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A26ConCodigo = P017D4_A26ConCodigo[0] ;
         A3CliCod = P017D4_A3CliCod[0] ;
         A1112AplIIGG = P017D4_A1112AplIIGG[0] ;
         n1112AplIIGG = P017D4_n1112AplIIGG[0] ;
         if ( ! (0==AV11AplIIGG) )
         {
            A1112AplIIGG = AV11AplIIGG ;
            n1112AplIIGG = false ;
         }
         /* Using cursor P017D5 */
         pr_default.execute(3, new Object[] {Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG), Integer.valueOf(A3CliCod), A26ConCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "importar_tipo_aplicacion_ganancias");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P017D2_A3CliCod = new int[1] ;
      P017D2_A1121AplIIGGPrrtear = new String[] {""} ;
      P017D2_A1112AplIIGG = new short[1] ;
      P017D2_n1112AplIIGG = new boolean[] {false} ;
      P017D2_A1113AplIIGGNom = new String[] {""} ;
      P017D2_A1114AplIIGGPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P017D2_A1115AplIIGGTopeTip = new byte[1] ;
      P017D2_A1109AplIIGGTopeVar = new String[] {""} ;
      P017D2_n1109AplIIGGTopeVar = new boolean[] {false} ;
      P017D2_A1111AplIIGGTopeCon = new String[] {""} ;
      P017D2_n1111AplIIGGTopeCon = new boolean[] {false} ;
      P017D2_A1124AplIIGGCondicion = new String[] {""} ;
      P017D2_n1124AplIIGGCondicion = new boolean[] {false} ;
      P017D2_A1117AplIIGGExenCon = new String[] {""} ;
      P017D2_n1117AplIIGGExenCon = new boolean[] {false} ;
      P017D2_A1118ApliIIGGExenOtr = new String[] {""} ;
      P017D2_n1118ApliIIGGExenOtr = new boolean[] {false} ;
      P017D2_A1119AplIIGGTopeFij = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P017D2_A1120AplIIGGTrat = new byte[1] ;
      A1121AplIIGGPrrtear = "" ;
      A1113AplIIGGNom = "" ;
      A1114AplIIGGPropor = DecimalUtil.ZERO ;
      A1109AplIIGGTopeVar = "" ;
      A1111AplIIGGTopeCon = "" ;
      A1124AplIIGGCondicion = "" ;
      A1117AplIIGGExenCon = "" ;
      A1118ApliIIGGExenOtr = "" ;
      A1119AplIIGGTopeFij = DecimalUtil.ZERO ;
      P017D3_A3CliCod = new int[1] ;
      P017D3_A1112AplIIGG = new short[1] ;
      P017D3_n1112AplIIGG = new boolean[] {false} ;
      P017D3_A26ConCodigo = new String[] {""} ;
      A26ConCodigo = "" ;
      AV12ConCodigo = "" ;
      P017D4_A26ConCodigo = new String[] {""} ;
      P017D4_A3CliCod = new int[1] ;
      P017D4_A1112AplIIGG = new short[1] ;
      P017D4_n1112AplIIGG = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importar_tipo_aplicacion_ganancias__default(),
         new Object[] {
             new Object[] {
            P017D2_A3CliCod, P017D2_A1121AplIIGGPrrtear, P017D2_A1112AplIIGG, P017D2_A1113AplIIGGNom, P017D2_A1114AplIIGGPropor, P017D2_A1115AplIIGGTopeTip, P017D2_A1109AplIIGGTopeVar, P017D2_n1109AplIIGGTopeVar, P017D2_A1111AplIIGGTopeCon, P017D2_n1111AplIIGGTopeCon,
            P017D2_A1124AplIIGGCondicion, P017D2_n1124AplIIGGCondicion, P017D2_A1117AplIIGGExenCon, P017D2_n1117AplIIGGExenCon, P017D2_A1118ApliIIGGExenOtr, P017D2_n1118ApliIIGGExenOtr, P017D2_A1119AplIIGGTopeFij, P017D2_A1120AplIIGGTrat
            }
            , new Object[] {
            P017D3_A3CliCod, P017D3_A1112AplIIGG, P017D3_n1112AplIIGG, P017D3_A26ConCodigo
            }
            , new Object[] {
            P017D4_A26ConCodigo, P017D4_A3CliCod, P017D4_A1112AplIIGG, P017D4_n1112AplIIGG
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A1115AplIIGGTopeTip ;
   private byte A1120AplIIGGTrat ;
   private short A1112AplIIGG ;
   private short AV13auxNum ;
   private short AV11AplIIGG ;
   private short Gx_err ;
   private int AV8OrigiCliCod ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private java.math.BigDecimal A1114AplIIGGPropor ;
   private java.math.BigDecimal A1119AplIIGGTopeFij ;
   private String scmdbuf ;
   private String A1121AplIIGGPrrtear ;
   private String A1109AplIIGGTopeVar ;
   private String A1111AplIIGGTopeCon ;
   private String A1124AplIIGGCondicion ;
   private String A1117AplIIGGExenCon ;
   private String A1118ApliIIGGExenOtr ;
   private String A26ConCodigo ;
   private String AV12ConCodigo ;
   private boolean n1112AplIIGG ;
   private boolean n1109AplIIGGTopeVar ;
   private boolean n1111AplIIGGTopeCon ;
   private boolean n1124AplIIGGCondicion ;
   private boolean n1117AplIIGGExenCon ;
   private boolean n1118ApliIIGGExenOtr ;
   private boolean returnInSub ;
   private String A1113AplIIGGNom ;
   private IDataStoreProvider pr_default ;
   private int[] P017D2_A3CliCod ;
   private String[] P017D2_A1121AplIIGGPrrtear ;
   private short[] P017D2_A1112AplIIGG ;
   private boolean[] P017D2_n1112AplIIGG ;
   private String[] P017D2_A1113AplIIGGNom ;
   private java.math.BigDecimal[] P017D2_A1114AplIIGGPropor ;
   private byte[] P017D2_A1115AplIIGGTopeTip ;
   private String[] P017D2_A1109AplIIGGTopeVar ;
   private boolean[] P017D2_n1109AplIIGGTopeVar ;
   private String[] P017D2_A1111AplIIGGTopeCon ;
   private boolean[] P017D2_n1111AplIIGGTopeCon ;
   private String[] P017D2_A1124AplIIGGCondicion ;
   private boolean[] P017D2_n1124AplIIGGCondicion ;
   private String[] P017D2_A1117AplIIGGExenCon ;
   private boolean[] P017D2_n1117AplIIGGExenCon ;
   private String[] P017D2_A1118ApliIIGGExenOtr ;
   private boolean[] P017D2_n1118ApliIIGGExenOtr ;
   private java.math.BigDecimal[] P017D2_A1119AplIIGGTopeFij ;
   private byte[] P017D2_A1120AplIIGGTrat ;
   private int[] P017D3_A3CliCod ;
   private short[] P017D3_A1112AplIIGG ;
   private boolean[] P017D3_n1112AplIIGG ;
   private String[] P017D3_A26ConCodigo ;
   private String[] P017D4_A26ConCodigo ;
   private int[] P017D4_A3CliCod ;
   private short[] P017D4_A1112AplIIGG ;
   private boolean[] P017D4_n1112AplIIGG ;
}

final  class importar_tipo_aplicacion_ganancias__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P017D2", "SELECT CliCod, AplIIGGPrrtear, AplIIGG, AplIIGGNom, AplIIGGPropor, AplIIGGTopeTip, AplIIGGTopeVar, AplIIGGTopeCon, AplIIGGCondicion, AplIIGGExenCon, ApliIIGGExenOtr, AplIIGGTopeFij, AplIIGGTrat FROM tipo_aplicacion_ganancias WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P017D3", "SELECT CliCod, AplIIGG, ConCodigo FROM Concepto WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P017D4", "SELECT ConCodigo, CliCod, AplIIGG FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo  FOR UPDATE OF Concepto",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P017D5", "SAVEPOINT gxupdate;UPDATE Concepto SET AplIIGG=?  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 40);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getString(8, 10);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((String[]) buf[12])[0] = rslt.getString(10, 10);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getString(11, 10);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(12,2);
               ((byte[]) buf[17])[0] = rslt.getByte(13);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 10);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 3 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               stmt.setInt(2, ((Number) parms[2]).intValue());
               stmt.setString(3, (String)parms[3], 10);
               return;
      }
   }

}

