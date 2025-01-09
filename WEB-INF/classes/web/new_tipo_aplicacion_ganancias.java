package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class new_tipo_aplicacion_ganancias extends GXProcedure
{
   public new_tipo_aplicacion_ganancias( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( new_tipo_aplicacion_ganancias.class ), "" );
   }

   public new_tipo_aplicacion_ganancias( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        java.math.BigDecimal aP3 ,
                        byte aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String aP7 ,
                        String aP8 ,
                        String aP9 ,
                        java.math.BigDecimal aP10 ,
                        byte aP11 ,
                        byte aP12 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             java.math.BigDecimal aP3 ,
                             byte aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String aP8 ,
                             String aP9 ,
                             java.math.BigDecimal aP10 ,
                             byte aP11 ,
                             byte aP12 )
   {
      new_tipo_aplicacion_ganancias.this.AV18CliCod = aP0;
      new_tipo_aplicacion_ganancias.this.AV17AplIIGG = aP1;
      new_tipo_aplicacion_ganancias.this.AV16AplIIGGNom = aP2;
      new_tipo_aplicacion_ganancias.this.AV15AplIIGGPropor = aP3;
      new_tipo_aplicacion_ganancias.this.AV14AplIIGGTopeTip = aP4;
      new_tipo_aplicacion_ganancias.this.AV13AplIIGGTopeVar = aP5;
      new_tipo_aplicacion_ganancias.this.AV12AplIIGGTopeCon = aP6;
      new_tipo_aplicacion_ganancias.this.AV10CondExenIIGG = aP7;
      new_tipo_aplicacion_ganancias.this.AV9AplIIGGExenCon = aP8;
      new_tipo_aplicacion_ganancias.this.AV8ApliIIGGExenOtr = aP9;
      new_tipo_aplicacion_ganancias.this.AV19AplIIGGTopeFij = aP10;
      new_tipo_aplicacion_ganancias.this.AV20AplIIGGTrat = aP11;
      new_tipo_aplicacion_ganancias.this.AV24prorratear = aP12;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE tipo_aplicacion_ganancias

      */
      A3CliCod = AV18CliCod ;
      A1112AplIIGG = AV17AplIIGG ;
      A1113AplIIGGNom = AV16AplIIGGNom ;
      A1114AplIIGGPropor = AV15AplIIGGPropor ;
      A1115AplIIGGTopeTip = AV14AplIIGGTopeTip ;
      if ( ! (GXutil.strcmp("", AV13AplIIGGTopeVar)==0) )
      {
         A1109AplIIGGTopeVar = AV13AplIIGGTopeVar ;
         n1109AplIIGGTopeVar = false ;
      }
      else
      {
         A1109AplIIGGTopeVar = "" ;
         n1109AplIIGGTopeVar = false ;
         n1109AplIIGGTopeVar = true ;
      }
      if ( ! (GXutil.strcmp("", AV12AplIIGGTopeCon)==0) )
      {
         GXv_boolean1[0] = AV22existe ;
         new web.existeconcepto(remoteHandle, context).execute( AV18CliCod, AV12AplIIGGTopeCon, GXv_boolean1) ;
         new_tipo_aplicacion_ganancias.this.AV22existe = GXv_boolean1[0] ;
         if ( AV22existe )
         {
            A1111AplIIGGTopeCon = AV12AplIIGGTopeCon ;
            n1111AplIIGGTopeCon = false ;
         }
         else
         {
            A1111AplIIGGTopeCon = "" ;
            n1111AplIIGGTopeCon = false ;
            n1111AplIIGGTopeCon = true ;
         }
      }
      else
      {
         A1111AplIIGGTopeCon = "" ;
         n1111AplIIGGTopeCon = false ;
         n1111AplIIGGTopeCon = true ;
      }
      GXv_boolean1[0] = AV23condicionExiste ;
      new web.condicioniiggexiste(remoteHandle, context).execute( AV18CliCod, AV10CondExenIIGG, GXv_boolean1) ;
      new_tipo_aplicacion_ganancias.this.AV23condicionExiste = GXv_boolean1[0] ;
      if ( ! (GXutil.strcmp("", AV10CondExenIIGG)==0) && ( AV23condicionExiste ) )
      {
         A1124AplIIGGCondicion = AV10CondExenIIGG ;
         n1124AplIIGGCondicion = false ;
      }
      else
      {
         A1124AplIIGGCondicion = "" ;
         n1124AplIIGGCondicion = false ;
         n1124AplIIGGCondicion = true ;
      }
      if ( ! (GXutil.strcmp("", AV9AplIIGGExenCon)==0) )
      {
         GXv_boolean1[0] = AV22existe ;
         new web.existeconcepto(remoteHandle, context).execute( AV18CliCod, AV9AplIIGGExenCon, GXv_boolean1) ;
         new_tipo_aplicacion_ganancias.this.AV22existe = GXv_boolean1[0] ;
         if ( AV22existe )
         {
            A1117AplIIGGExenCon = AV9AplIIGGExenCon ;
            n1117AplIIGGExenCon = false ;
         }
         else
         {
            A1117AplIIGGExenCon = "" ;
            n1117AplIIGGExenCon = false ;
            n1117AplIIGGExenCon = true ;
         }
      }
      else
      {
         A1117AplIIGGExenCon = "" ;
         n1117AplIIGGExenCon = false ;
         n1117AplIIGGExenCon = true ;
      }
      if ( ! (GXutil.strcmp("", AV8ApliIIGGExenOtr)==0) )
      {
         GXv_boolean1[0] = AV22existe ;
         new web.existeconcepto(remoteHandle, context).execute( AV18CliCod, AV8ApliIIGGExenOtr, GXv_boolean1) ;
         new_tipo_aplicacion_ganancias.this.AV22existe = GXv_boolean1[0] ;
         if ( AV22existe )
         {
            A1118ApliIIGGExenOtr = AV8ApliIIGGExenOtr ;
            n1118ApliIIGGExenOtr = false ;
            A1118ApliIIGGExenOtr = "" ;
            n1118ApliIIGGExenOtr = false ;
            n1118ApliIIGGExenOtr = true ;
         }
      }
      else
      {
         A1118ApliIIGGExenOtr = "" ;
         n1118ApliIIGGExenOtr = false ;
         n1118ApliIIGGExenOtr = true ;
      }
      A1119AplIIGGTopeFij = AV19AplIIGGTopeFij ;
      A1120AplIIGGTrat = AV20AplIIGGTrat ;
      if ( AV24prorratear == 0 )
      {
         A1121AplIIGGPrrtear = "SIN" ;
      }
      else
      {
         if ( AV24prorratear == 1 )
         {
            A1121AplIIGGPrrtear = "FIJA" ;
         }
         else
         {
            A1121AplIIGGPrrtear = "VAR" ;
         }
      }
      A1998AplIIGGgRelSec = 0 ;
      A1999AplIIGGRelSecCli = 0 ;
      A2000AplIIGGPadre = (short)(0) ;
      A2020AplIIGGRelRef = "" ;
      A2028AplIIGGOld = "" ;
      /* Using cursor P01712 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1112AplIIGG), Boolean.valueOf(n1109AplIIGGTopeVar), A1109AplIIGGTopeVar, Boolean.valueOf(n1111AplIIGGTopeCon), A1111AplIIGGTopeCon, A1113AplIIGGNom, A1114AplIIGGPropor, Byte.valueOf(A1115AplIIGGTopeTip), Boolean.valueOf(n1117AplIIGGExenCon), A1117AplIIGGExenCon, Boolean.valueOf(n1118ApliIIGGExenOtr), A1118ApliIIGGExenOtr, A1119AplIIGGTopeFij, Byte.valueOf(A1120AplIIGGTrat), A1121AplIIGGPrrtear, Boolean.valueOf(n1124AplIIGGCondicion), A1124AplIIGGCondicion, Integer.valueOf(A1998AplIIGGgRelSec), Integer.valueOf(A1999AplIIGGRelSecCli), Short.valueOf(A2000AplIIGGPadre), A2020AplIIGGRelRef, A2028AplIIGGOld});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("tipo_aplicacion_ganancias");
      if ( (pr_default.getStatus(0) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "new_tipo_aplicacion_ganancias");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A1113AplIIGGNom = "" ;
      A1114AplIIGGPropor = DecimalUtil.ZERO ;
      A1109AplIIGGTopeVar = "" ;
      A1111AplIIGGTopeCon = "" ;
      A1124AplIIGGCondicion = "" ;
      A1117AplIIGGExenCon = "" ;
      GXv_boolean1 = new boolean[1] ;
      A1118ApliIIGGExenOtr = "" ;
      A1119AplIIGGTopeFij = DecimalUtil.ZERO ;
      A1121AplIIGGPrrtear = "" ;
      A2020AplIIGGRelRef = "" ;
      A2028AplIIGGOld = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.new_tipo_aplicacion_ganancias__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV14AplIIGGTopeTip ;
   private byte AV20AplIIGGTrat ;
   private byte AV24prorratear ;
   private byte A1115AplIIGGTopeTip ;
   private byte A1120AplIIGGTrat ;
   private short AV17AplIIGG ;
   private short A1112AplIIGG ;
   private short A2000AplIIGGPadre ;
   private short Gx_err ;
   private int AV18CliCod ;
   private int GX_INS126 ;
   private int A3CliCod ;
   private int A1998AplIIGGgRelSec ;
   private int A1999AplIIGGRelSecCli ;
   private java.math.BigDecimal AV15AplIIGGPropor ;
   private java.math.BigDecimal AV19AplIIGGTopeFij ;
   private java.math.BigDecimal A1114AplIIGGPropor ;
   private java.math.BigDecimal A1119AplIIGGTopeFij ;
   private String AV13AplIIGGTopeVar ;
   private String AV12AplIIGGTopeCon ;
   private String AV10CondExenIIGG ;
   private String AV9AplIIGGExenCon ;
   private String AV8ApliIIGGExenOtr ;
   private String A1109AplIIGGTopeVar ;
   private String A1111AplIIGGTopeCon ;
   private String A1124AplIIGGCondicion ;
   private String A1117AplIIGGExenCon ;
   private String A1118ApliIIGGExenOtr ;
   private String A1121AplIIGGPrrtear ;
   private String Gx_emsg ;
   private boolean n1109AplIIGGTopeVar ;
   private boolean AV22existe ;
   private boolean n1111AplIIGGTopeCon ;
   private boolean AV23condicionExiste ;
   private boolean n1124AplIIGGCondicion ;
   private boolean n1117AplIIGGExenCon ;
   private boolean GXv_boolean1[] ;
   private boolean n1118ApliIIGGExenOtr ;
   private String A2028AplIIGGOld ;
   private String AV16AplIIGGNom ;
   private String A1113AplIIGGNom ;
   private String A2020AplIIGGRelRef ;
   private IDataStoreProvider pr_default ;
}

final  class new_tipo_aplicacion_ganancias__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01712", "SAVEPOINT gxupdate;INSERT INTO tipo_aplicacion_ganancias(CliCod, AplIIGG, AplIIGGTopeVar, AplIIGGTopeCon, AplIIGGNom, AplIIGGPropor, AplIIGGTopeTip, AplIIGGExenCon, ApliIIGGExenOtr, AplIIGGTopeFij, AplIIGGTrat, AplIIGGPrrtear, AplIIGGCondicion, AplIIGGgRelSec, AplIIGGRelSecCli, AplIIGGPadre, AplIIGGRelRef, AplIIGGOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 40);
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(4, (String)parms[5], 10);
               }
               stmt.setVarchar(5, (String)parms[6], 400, false);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[7], 4);
               stmt.setByte(7, ((Number) parms[8]).byteValue());
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(8, (String)parms[10], 10);
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(9, (String)parms[12], 10);
               }
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[13], 2);
               stmt.setByte(11, ((Number) parms[14]).byteValue());
               stmt.setString(12, (String)parms[15], 20);
               if ( ((Boolean) parms[16]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(13, (String)parms[17], 20);
               }
               stmt.setInt(14, ((Number) parms[18]).intValue());
               stmt.setInt(15, ((Number) parms[19]).intValue());
               stmt.setShort(16, ((Number) parms[20]).shortValue());
               stmt.setVarchar(17, (String)parms[21], 40, false);
               stmt.setNLongVarchar(18, (String)parms[22], false);
               return;
      }
   }

}

