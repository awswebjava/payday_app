package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getsiradigpropor extends GXProcedure
{
   public getsiradigpropor( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getsiradigpropor.class ), "" );
   }

   public getsiradigpropor( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           String aP1 ,
                                           String aP2 ,
                                           String aP3 )
   {
      getsiradigpropor.this.aP4 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        java.math.BigDecimal[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             java.math.BigDecimal[] aP4 )
   {
      getsiradigpropor.this.AV8CliCod = aP0;
      getsiradigpropor.this.AV9SiraTipo = aP1;
      getsiradigpropor.this.AV10SiraCodigo = aP2;
      getsiradigpropor.this.AV11SiraConCodigo = aP3;
      getsiradigpropor.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV15GXLvl1 = (byte)(0) ;
      /* Using cursor P017L2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9SiraTipo, AV10SiraCodigo, AV11SiraConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1100SiraConCodigo = P017L2_A1100SiraConCodigo[0] ;
         A1102SiraCodigo = P017L2_A1102SiraCodigo[0] ;
         A1101SiraTipo = P017L2_A1101SiraTipo[0] ;
         A3CliCod = P017L2_A3CliCod[0] ;
         A1103SiraPropor = P017L2_A1103SiraPropor[0] ;
         AV15GXLvl1 = (byte)(1) ;
         AV12SiraPropor = A1103SiraPropor ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV15GXLvl1 == 0 )
      {
         AV12SiraPropor = DecimalUtil.doubleToDec(1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getsiradigpropor.this.AV12SiraPropor;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12SiraPropor = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P017L2_A1100SiraConCodigo = new String[] {""} ;
      P017L2_A1102SiraCodigo = new String[] {""} ;
      P017L2_A1101SiraTipo = new String[] {""} ;
      P017L2_A3CliCod = new int[1] ;
      P017L2_A1103SiraPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A1100SiraConCodigo = "" ;
      A1102SiraCodigo = "" ;
      A1101SiraTipo = "" ;
      A1103SiraPropor = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getsiradigpropor__default(),
         new Object[] {
             new Object[] {
            P017L2_A1100SiraConCodigo, P017L2_A1102SiraCodigo, P017L2_A1101SiraTipo, P017L2_A3CliCod, P017L2_A1103SiraPropor
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV15GXLvl1 ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private java.math.BigDecimal AV12SiraPropor ;
   private java.math.BigDecimal A1103SiraPropor ;
   private String AV9SiraTipo ;
   private String AV10SiraCodigo ;
   private String AV11SiraConCodigo ;
   private String scmdbuf ;
   private String A1100SiraConCodigo ;
   private String A1102SiraCodigo ;
   private String A1101SiraTipo ;
   private java.math.BigDecimal[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P017L2_A1100SiraConCodigo ;
   private String[] P017L2_A1102SiraCodigo ;
   private String[] P017L2_A1101SiraTipo ;
   private int[] P017L2_A3CliCod ;
   private java.math.BigDecimal[] P017L2_A1103SiraPropor ;
}

final  class getsiradigpropor__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P017L2", "SELECT SiraConCodigo, SiraCodigo, SiraTipo, CliCod, SiraPropor FROM siradig_codigos WHERE (CliCod = ? and SiraTipo = ( ?) and SiraCodigo = ( ?)) AND (SiraConCodigo = ( ?)) ORDER BY CliCod, SiraTipo, SiraCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
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
               stmt.setString(2, (String)parms[1], 3);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 10);
               return;
      }
   }

}

