package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class importar_siradig_codigos extends GXProcedure
{
   public importar_siradig_codigos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importar_siradig_codigos.class ), "" );
   }

   public importar_siradig_codigos( int remoteHandle ,
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
      importar_siradig_codigos.this.AV13Orig_CliCod = aP0;
      importar_siradig_codigos.this.AV8CliCod = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P016X2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13Orig_CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P016X2_A3CliCod[0] ;
         A1103SiraPropor = P016X2_A1103SiraPropor[0] ;
         A1100SiraConCodigo = P016X2_A1100SiraConCodigo[0] ;
         A1102SiraCodigo = P016X2_A1102SiraCodigo[0] ;
         A1101SiraTipo = P016X2_A1101SiraTipo[0] ;
         AV9SiraPropor = A1103SiraPropor ;
         AV10SiraConCodigo = A1100SiraConCodigo ;
         AV11SiraCodigo = A1102SiraCodigo ;
         AV14SiraTipo = A1101SiraTipo ;
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
      GXv_boolean1[0] = AV15existe ;
      new web.existeconcepto(remoteHandle, context).execute( AV8CliCod, AV10SiraConCodigo, GXv_boolean1) ;
      importar_siradig_codigos.this.AV15existe = GXv_boolean1[0] ;
      if ( AV15existe )
      {
         /*
            INSERT RECORD ON TABLE siradig_codigos

         */
         A3CliCod = AV8CliCod ;
         A1101SiraTipo = AV14SiraTipo ;
         A1102SiraCodigo = AV11SiraCodigo ;
         A1100SiraConCodigo = AV10SiraConCodigo ;
         A1103SiraPropor = AV9SiraPropor ;
         /* Using cursor P016X3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A1101SiraTipo, A1102SiraCodigo, A1100SiraConCodigo, A1103SiraPropor});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("siradig_codigos");
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
      Application.commitDataStores(context, remoteHandle, pr_default, "importar_siradig_codigos");
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
      P016X2_A3CliCod = new int[1] ;
      P016X2_A1103SiraPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P016X2_A1100SiraConCodigo = new String[] {""} ;
      P016X2_A1102SiraCodigo = new String[] {""} ;
      P016X2_A1101SiraTipo = new String[] {""} ;
      A1103SiraPropor = DecimalUtil.ZERO ;
      A1100SiraConCodigo = "" ;
      A1102SiraCodigo = "" ;
      A1101SiraTipo = "" ;
      AV9SiraPropor = DecimalUtil.ZERO ;
      AV10SiraConCodigo = "" ;
      AV11SiraCodigo = "" ;
      AV14SiraTipo = "" ;
      GXv_boolean1 = new boolean[1] ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importar_siradig_codigos__default(),
         new Object[] {
             new Object[] {
            P016X2_A3CliCod, P016X2_A1103SiraPropor, P016X2_A1100SiraConCodigo, P016X2_A1102SiraCodigo, P016X2_A1101SiraTipo
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV13Orig_CliCod ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private int GX_INS123 ;
   private java.math.BigDecimal A1103SiraPropor ;
   private java.math.BigDecimal AV9SiraPropor ;
   private String scmdbuf ;
   private String A1100SiraConCodigo ;
   private String A1102SiraCodigo ;
   private String A1101SiraTipo ;
   private String AV10SiraConCodigo ;
   private String AV11SiraCodigo ;
   private String AV14SiraTipo ;
   private String Gx_emsg ;
   private boolean returnInSub ;
   private boolean AV15existe ;
   private boolean GXv_boolean1[] ;
   private IDataStoreProvider pr_default ;
   private int[] P016X2_A3CliCod ;
   private java.math.BigDecimal[] P016X2_A1103SiraPropor ;
   private String[] P016X2_A1100SiraConCodigo ;
   private String[] P016X2_A1102SiraCodigo ;
   private String[] P016X2_A1101SiraTipo ;
}

final  class importar_siradig_codigos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P016X2", "SELECT CliCod, SiraPropor, SiraConCodigo, SiraCodigo, SiraTipo FROM siradig_codigos WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P016X3", "SAVEPOINT gxupdate;INSERT INTO siradig_codigos(CliCod, SiraTipo, SiraCodigo, SiraConCodigo, SiraPropor, SiraRelSec, SiraRelSecCli, SiraTipoPadre, SiraCodPadre, SiraRelRef, SiraOld) VALUES(?, ?, ?, ?, ?, 0, 0, '', '', '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,4);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 3);
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
               stmt.setString(2, (String)parms[1], 3);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 10);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               return;
      }
   }

}

