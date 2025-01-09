package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conceptoafipgettildes extends GXProcedure
{
   public conceptoafipgettildes( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptoafipgettildes.class ), "" );
   }

   public conceptoafipgettildes( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           String aP1 ,
                           byte[] aP2 ,
                           byte[] aP3 ,
                           byte[] aP4 ,
                           byte[] aP5 ,
                           byte[] aP6 ,
                           byte[] aP7 ,
                           byte[] aP8 ,
                           byte[] aP9 ,
                           byte[] aP10 ,
                           byte[] aP11 ,
                           byte[] aP12 ,
                           byte[] aP13 ,
                           byte[] aP14 ,
                           byte[] aP15 )
   {
      conceptoafipgettildes.this.aP16 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16);
      return aP16[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        byte[] aP2 ,
                        byte[] aP3 ,
                        byte[] aP4 ,
                        byte[] aP5 ,
                        byte[] aP6 ,
                        byte[] aP7 ,
                        byte[] aP8 ,
                        byte[] aP9 ,
                        byte[] aP10 ,
                        byte[] aP11 ,
                        byte[] aP12 ,
                        byte[] aP13 ,
                        byte[] aP14 ,
                        byte[] aP15 ,
                        byte[] aP16 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             byte[] aP2 ,
                             byte[] aP3 ,
                             byte[] aP4 ,
                             byte[] aP5 ,
                             byte[] aP6 ,
                             byte[] aP7 ,
                             byte[] aP8 ,
                             byte[] aP9 ,
                             byte[] aP10 ,
                             byte[] aP11 ,
                             byte[] aP12 ,
                             byte[] aP13 ,
                             byte[] aP14 ,
                             byte[] aP15 ,
                             byte[] aP16 )
   {
      conceptoafipgettildes.this.AV8CliCod = aP0;
      conceptoafipgettildes.this.AV9ConCodPropio = aP1;
      conceptoafipgettildes.this.aP2 = aP2;
      conceptoafipgettildes.this.aP3 = aP3;
      conceptoafipgettildes.this.aP4 = aP4;
      conceptoafipgettildes.this.aP5 = aP5;
      conceptoafipgettildes.this.aP6 = aP6;
      conceptoafipgettildes.this.aP7 = aP7;
      conceptoafipgettildes.this.aP8 = aP8;
      conceptoafipgettildes.this.aP9 = aP9;
      conceptoafipgettildes.this.aP10 = aP10;
      conceptoafipgettildes.this.aP11 = aP11;
      conceptoafipgettildes.this.aP12 = aP12;
      conceptoafipgettildes.this.aP13 = aP13;
      conceptoafipgettildes.this.aP14 = aP14;
      conceptoafipgettildes.this.aP15 = aP15;
      conceptoafipgettildes.this.aP16 = aP16;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01462 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9ConCodPropio});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P01462_A26ConCodigo[0] ;
         A3CliCod = P01462_A3CliCod[0] ;
         A1472ConSIPAApo = P01462_A1472ConSIPAApo[0] ;
         A1473ConSIPACont = P01462_A1473ConSIPACont[0] ;
         A1474ConINSSJyPApo = P01462_A1474ConINSSJyPApo[0] ;
         A1475ConINSSJyPCont = P01462_A1475ConINSSJyPCont[0] ;
         A1476ConObraSocApo = P01462_A1476ConObraSocApo[0] ;
         A1477ConObraSocCont = P01462_A1477ConObraSocCont[0] ;
         A1478ConFonSolRedApo = P01462_A1478ConFonSolRedApo[0] ;
         A1479ConFonSolRedCont = P01462_A1479ConFonSolRedCont[0] ;
         A1480ConRenateaApo = P01462_A1480ConRenateaApo[0] ;
         A1481ConRenateaCont = P01462_A1481ConRenateaCont[0] ;
         A1482ConAsigFamCont = P01462_A1482ConAsigFamCont[0] ;
         A1483ConFonNacEmpCont = P01462_A1483ConFonNacEmpCont[0] ;
         A1484ConLeyRieTrabCont = P01462_A1484ConLeyRieTrabCont[0] ;
         A1485ConRegDifApo = P01462_A1485ConRegDifApo[0] ;
         A1486ConRegEspApo = P01462_A1486ConRegEspApo[0] ;
         AV12LiqDSIPAApo = A1472ConSIPAApo ;
         AV13LiqDSIPACont = A1473ConSIPACont ;
         AV14LiqDINSSJyPApo = A1474ConINSSJyPApo ;
         AV17LiqDINSSJyPCont = A1475ConINSSJyPCont ;
         AV18LiqDObraSocApo = A1476ConObraSocApo ;
         AV19LiqDObraSocCont = A1477ConObraSocCont ;
         AV20LiqDFonSolRedApo = A1478ConFonSolRedApo ;
         AV21LiqDFonSolRedCont = A1479ConFonSolRedCont ;
         AV22LiqDRenateaApo = A1480ConRenateaApo ;
         AV23LiqDRenateaCont = A1481ConRenateaCont ;
         AV26LiqDAsigFamCont = A1482ConAsigFamCont ;
         AV24LiqDFonNacEmpCont = A1483ConFonNacEmpCont ;
         AV15LiqDLeyRieTrabCont = A1484ConLeyRieTrabCont ;
         AV16LiqDRegDifApo = A1485ConRegDifApo ;
         AV25LiqDRegEspApo = A1486ConRegEspApo ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = conceptoafipgettildes.this.AV12LiqDSIPAApo;
      this.aP3[0] = conceptoafipgettildes.this.AV13LiqDSIPACont;
      this.aP4[0] = conceptoafipgettildes.this.AV14LiqDINSSJyPApo;
      this.aP5[0] = conceptoafipgettildes.this.AV17LiqDINSSJyPCont;
      this.aP6[0] = conceptoafipgettildes.this.AV18LiqDObraSocApo;
      this.aP7[0] = conceptoafipgettildes.this.AV19LiqDObraSocCont;
      this.aP8[0] = conceptoafipgettildes.this.AV20LiqDFonSolRedApo;
      this.aP9[0] = conceptoafipgettildes.this.AV21LiqDFonSolRedCont;
      this.aP10[0] = conceptoafipgettildes.this.AV22LiqDRenateaApo;
      this.aP11[0] = conceptoafipgettildes.this.AV23LiqDRenateaCont;
      this.aP12[0] = conceptoafipgettildes.this.AV26LiqDAsigFamCont;
      this.aP13[0] = conceptoafipgettildes.this.AV24LiqDFonNacEmpCont;
      this.aP14[0] = conceptoafipgettildes.this.AV15LiqDLeyRieTrabCont;
      this.aP15[0] = conceptoafipgettildes.this.AV16LiqDRegDifApo;
      this.aP16[0] = conceptoafipgettildes.this.AV25LiqDRegEspApo;
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
      P01462_A26ConCodigo = new String[] {""} ;
      P01462_A3CliCod = new int[1] ;
      P01462_A1472ConSIPAApo = new byte[1] ;
      P01462_A1473ConSIPACont = new byte[1] ;
      P01462_A1474ConINSSJyPApo = new byte[1] ;
      P01462_A1475ConINSSJyPCont = new byte[1] ;
      P01462_A1476ConObraSocApo = new byte[1] ;
      P01462_A1477ConObraSocCont = new byte[1] ;
      P01462_A1478ConFonSolRedApo = new byte[1] ;
      P01462_A1479ConFonSolRedCont = new byte[1] ;
      P01462_A1480ConRenateaApo = new byte[1] ;
      P01462_A1481ConRenateaCont = new byte[1] ;
      P01462_A1482ConAsigFamCont = new byte[1] ;
      P01462_A1483ConFonNacEmpCont = new byte[1] ;
      P01462_A1484ConLeyRieTrabCont = new byte[1] ;
      P01462_A1485ConRegDifApo = new byte[1] ;
      P01462_A1486ConRegEspApo = new byte[1] ;
      A26ConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptoafipgettildes__default(),
         new Object[] {
             new Object[] {
            P01462_A26ConCodigo, P01462_A3CliCod, P01462_A1472ConSIPAApo, P01462_A1473ConSIPACont, P01462_A1474ConINSSJyPApo, P01462_A1475ConINSSJyPCont, P01462_A1476ConObraSocApo, P01462_A1477ConObraSocCont, P01462_A1478ConFonSolRedApo, P01462_A1479ConFonSolRedCont,
            P01462_A1480ConRenateaApo, P01462_A1481ConRenateaCont, P01462_A1482ConAsigFamCont, P01462_A1483ConFonNacEmpCont, P01462_A1484ConLeyRieTrabCont, P01462_A1485ConRegDifApo, P01462_A1486ConRegEspApo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV12LiqDSIPAApo ;
   private byte AV13LiqDSIPACont ;
   private byte AV14LiqDINSSJyPApo ;
   private byte AV17LiqDINSSJyPCont ;
   private byte AV18LiqDObraSocApo ;
   private byte AV19LiqDObraSocCont ;
   private byte AV20LiqDFonSolRedApo ;
   private byte AV21LiqDFonSolRedCont ;
   private byte AV22LiqDRenateaApo ;
   private byte AV23LiqDRenateaCont ;
   private byte AV26LiqDAsigFamCont ;
   private byte AV24LiqDFonNacEmpCont ;
   private byte AV15LiqDLeyRieTrabCont ;
   private byte AV16LiqDRegDifApo ;
   private byte AV25LiqDRegEspApo ;
   private byte A1472ConSIPAApo ;
   private byte A1473ConSIPACont ;
   private byte A1474ConINSSJyPApo ;
   private byte A1475ConINSSJyPCont ;
   private byte A1476ConObraSocApo ;
   private byte A1477ConObraSocCont ;
   private byte A1478ConFonSolRedApo ;
   private byte A1479ConFonSolRedCont ;
   private byte A1480ConRenateaApo ;
   private byte A1481ConRenateaCont ;
   private byte A1482ConAsigFamCont ;
   private byte A1483ConFonNacEmpCont ;
   private byte A1484ConLeyRieTrabCont ;
   private byte A1485ConRegDifApo ;
   private byte A1486ConRegEspApo ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV9ConCodPropio ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private byte[] aP16 ;
   private byte[] aP2 ;
   private byte[] aP3 ;
   private byte[] aP4 ;
   private byte[] aP5 ;
   private byte[] aP6 ;
   private byte[] aP7 ;
   private byte[] aP8 ;
   private byte[] aP9 ;
   private byte[] aP10 ;
   private byte[] aP11 ;
   private byte[] aP12 ;
   private byte[] aP13 ;
   private byte[] aP14 ;
   private byte[] aP15 ;
   private IDataStoreProvider pr_default ;
   private String[] P01462_A26ConCodigo ;
   private int[] P01462_A3CliCod ;
   private byte[] P01462_A1472ConSIPAApo ;
   private byte[] P01462_A1473ConSIPACont ;
   private byte[] P01462_A1474ConINSSJyPApo ;
   private byte[] P01462_A1475ConINSSJyPCont ;
   private byte[] P01462_A1476ConObraSocApo ;
   private byte[] P01462_A1477ConObraSocCont ;
   private byte[] P01462_A1478ConFonSolRedApo ;
   private byte[] P01462_A1479ConFonSolRedCont ;
   private byte[] P01462_A1480ConRenateaApo ;
   private byte[] P01462_A1481ConRenateaCont ;
   private byte[] P01462_A1482ConAsigFamCont ;
   private byte[] P01462_A1483ConFonNacEmpCont ;
   private byte[] P01462_A1484ConLeyRieTrabCont ;
   private byte[] P01462_A1485ConRegDifApo ;
   private byte[] P01462_A1486ConRegEspApo ;
}

final  class conceptoafipgettildes__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01462", "SELECT ConCodigo, CliCod, ConSIPAApo, ConSIPACont, ConINSSJyPApo, ConINSSJyPCont, ConObraSocApo, ConObraSocCont, ConFonSolRedApo, ConFonSolRedCont, ConRenateaApo, ConRenateaCont, ConAsigFamCont, ConFonNacEmpCont, ConLeyRieTrabCont, ConRegDifApo, ConRegEspApo FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((byte[]) buf[12])[0] = rslt.getByte(13);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((byte[]) buf[14])[0] = rslt.getByte(15);
               ((byte[]) buf[15])[0] = rslt.getByte(16);
               ((byte[]) buf[16])[0] = rslt.getByte(17);
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
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

