package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class importar_concepto_motivos extends GXProcedure
{
   public importar_concepto_motivos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importar_concepto_motivos.class ), "" );
   }

   public importar_concepto_motivos( int remoteHandle ,
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
      importar_concepto_motivos.this.AV15Orig_CliCod = aP0;
      importar_concepto_motivos.this.AV9CliCod = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01F62 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV15Orig_CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P01F62_A3CliCod[0] ;
         A26ConCodigo = P01F62_A26ConCodigo[0] ;
         A11MegCodigo = P01F62_A11MegCodigo[0] ;
         A1529ConMegPropor = P01F62_A1529ConMegPropor[0] ;
         A1530ConMegMeses = P01F62_A1530ConMegMeses[0] ;
         A1532MegPreaTipo = P01F62_A1532MegPreaTipo[0] ;
         A2077ConMegSec = P01F62_A2077ConMegSec[0] ;
         A1534ConMegDura = P01F62_A1534ConMegDura[0] ;
         AV11ConCodigo = A26ConCodigo ;
         AV10MegCodigo = A11MegCodigo ;
         AV12ConMegPropor = A1529ConMegPropor ;
         AV13ConMegMeses = A1530ConMegMeses ;
         AV14MegPreaTipo = A1532MegPreaTipo ;
         AV18ConMegSec = A2077ConMegSec ;
         AV19ConMegDura = A1534ConMegDura ;
         /* Execute user subroutine: 'NEW' */
         S111 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   public void S111( )
   {
      /* 'NEW' Routine */
      returnInSub = false ;
      GXv_boolean1[0] = AV17existe ;
      new web.existeconcepto(remoteHandle, context).execute( AV9CliCod, AV11ConCodigo, GXv_boolean1) ;
      importar_concepto_motivos.this.AV17existe = GXv_boolean1[0] ;
      if ( AV17existe )
      {
         /*
            INSERT RECORD ON TABLE ConceptoMotivosEgreso

         */
         A3CliCod = AV9CliCod ;
         A26ConCodigo = AV11ConCodigo ;
         A11MegCodigo = AV10MegCodigo ;
         A1529ConMegPropor = AV12ConMegPropor ;
         A1530ConMegMeses = AV13ConMegMeses ;
         A1532MegPreaTipo = AV14MegPreaTipo ;
         A1534ConMegDura = AV19ConMegDura ;
         A2077ConMegSec = AV18ConMegSec ;
         /* Using cursor P01F63 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A11MegCodigo, Short.valueOf(A2077ConMegSec), A1532MegPreaTipo, Byte.valueOf(A1530ConMegMeses), A1534ConMegDura, A1529ConMegPropor});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoMotivosEgreso");
         if ( (pr_default.getStatus(1) == 1) )
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
      }
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "importar_concepto_motivos");
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
      P01F62_A3CliCod = new int[1] ;
      P01F62_A26ConCodigo = new String[] {""} ;
      P01F62_A11MegCodigo = new String[] {""} ;
      P01F62_A1529ConMegPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01F62_A1530ConMegMeses = new byte[1] ;
      P01F62_A1532MegPreaTipo = new String[] {""} ;
      P01F62_A2077ConMegSec = new short[1] ;
      P01F62_A1534ConMegDura = new String[] {""} ;
      A26ConCodigo = "" ;
      A11MegCodigo = "" ;
      A1529ConMegPropor = DecimalUtil.ZERO ;
      A1532MegPreaTipo = "" ;
      A1534ConMegDura = "" ;
      AV11ConCodigo = "" ;
      AV10MegCodigo = "" ;
      AV12ConMegPropor = DecimalUtil.ZERO ;
      AV14MegPreaTipo = "" ;
      AV19ConMegDura = "" ;
      GXv_boolean1 = new boolean[1] ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importar_concepto_motivos__default(),
         new Object[] {
             new Object[] {
            P01F62_A3CliCod, P01F62_A26ConCodigo, P01F62_A11MegCodigo, P01F62_A1529ConMegPropor, P01F62_A1530ConMegMeses, P01F62_A1532MegPreaTipo, P01F62_A2077ConMegSec, P01F62_A1534ConMegDura
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A1530ConMegMeses ;
   private byte AV13ConMegMeses ;
   private short A2077ConMegSec ;
   private short AV18ConMegSec ;
   private short Gx_err ;
   private int AV15Orig_CliCod ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private int GX_INS261 ;
   private java.math.BigDecimal A1529ConMegPropor ;
   private java.math.BigDecimal AV12ConMegPropor ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String A11MegCodigo ;
   private String A1532MegPreaTipo ;
   private String A1534ConMegDura ;
   private String AV11ConCodigo ;
   private String AV10MegCodigo ;
   private String AV14MegPreaTipo ;
   private String AV19ConMegDura ;
   private String Gx_emsg ;
   private boolean returnInSub ;
   private boolean AV17existe ;
   private boolean GXv_boolean1[] ;
   private IDataStoreProvider pr_default ;
   private int[] P01F62_A3CliCod ;
   private String[] P01F62_A26ConCodigo ;
   private String[] P01F62_A11MegCodigo ;
   private java.math.BigDecimal[] P01F62_A1529ConMegPropor ;
   private byte[] P01F62_A1530ConMegMeses ;
   private String[] P01F62_A1532MegPreaTipo ;
   private short[] P01F62_A2077ConMegSec ;
   private String[] P01F62_A1534ConMegDura ;
}

final  class importar_concepto_motivos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01F62", "SELECT CliCod, ConCodigo, MegCodigo, ConMegPropor, ConMegMeses, MegPreaTipo, ConMegSec, ConMegDura FROM ConceptoMotivosEgreso WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P01F63", "SAVEPOINT gxupdate;INSERT INTO ConceptoMotivosEgreso(CliCod, ConCodigo, MegCodigo, ConMegSec, MegPreaTipo, ConMegMeses, ConMegDura, ConMegPropor) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
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
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               return;
      }
   }

}

