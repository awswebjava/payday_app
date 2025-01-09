package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class inicializarconceptosafipdefault extends GXProcedure
{
   public inicializarconceptosafipdefault( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( inicializarconceptosafipdefault.class ), "" );
   }

   public inicializarconceptosafipdefault( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             String aP1 )
   {
      inicializarconceptosafipdefault.this.AV8CliCod = aP0;
      inicializarconceptosafipdefault.this.AV25ConCodigo = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "1 !&CliCod	", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))+httpContext.getMessage( " concodigo ", "")+AV25ConCodigo) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV25ConCodigo ,
                                           A26ConCodigo ,
                                           Integer.valueOf(AV8CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      /* Using cursor P012X2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV25ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P012X2_A26ConCodigo[0] ;
         A3CliCod = P012X2_A3CliCod[0] ;
         A37TipoConCod = P012X2_A37TipoConCod[0] ;
         A1648ConCodAfip = P012X2_A1648ConCodAfip[0] ;
         A1472ConSIPAApo = P012X2_A1472ConSIPAApo[0] ;
         A1473ConSIPACont = P012X2_A1473ConSIPACont[0] ;
         A1474ConINSSJyPApo = P012X2_A1474ConINSSJyPApo[0] ;
         A1475ConINSSJyPCont = P012X2_A1475ConINSSJyPCont[0] ;
         A1476ConObraSocApo = P012X2_A1476ConObraSocApo[0] ;
         A1477ConObraSocCont = P012X2_A1477ConObraSocCont[0] ;
         A1478ConFonSolRedApo = P012X2_A1478ConFonSolRedApo[0] ;
         A1479ConFonSolRedCont = P012X2_A1479ConFonSolRedCont[0] ;
         A1480ConRenateaApo = P012X2_A1480ConRenateaApo[0] ;
         A1481ConRenateaCont = P012X2_A1481ConRenateaCont[0] ;
         A1482ConAsigFamCont = P012X2_A1482ConAsigFamCont[0] ;
         A1483ConFonNacEmpCont = P012X2_A1483ConFonNacEmpCont[0] ;
         A1484ConLeyRieTrabCont = P012X2_A1484ConLeyRieTrabCont[0] ;
         A1485ConRegDifApo = P012X2_A1485ConRegDifApo[0] ;
         A1486ConRegEspApo = P012X2_A1486ConRegEspApo[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "TipoConCod ", "")+A37TipoConCod) ;
         if ( GXutil.strcmp(A37TipoConCod, "CAL_ARG") != 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "crea ", "")+GXutil.trim( A26ConCodigo)) ;
            GXv_char1[0] = AV23ConAFIPSIPAApo ;
            GXv_char2[0] = AV22ConAFIPINSSJyPCont ;
            GXv_char3[0] = AV21ConAFIPFonSolRedApo ;
            GXv_char4[0] = AV20ConAFIPFonSolRedCont ;
            GXv_char5[0] = AV19ConAFIPAsigFamCont ;
            GXv_char6[0] = AV18ConAFIPRegEspApo ;
            GXv_char7[0] = AV17ConAFIPRegDifApo ;
            GXv_char8[0] = AV16ConAFIPRenateaCont ;
            GXv_char9[0] = AV15ConAFIPSIPACont ;
            GXv_char10[0] = AV14ConAFIPINSSJyPApo ;
            GXv_char11[0] = AV13ConAFIPObraSocApo ;
            GXv_char12[0] = AV12ConAFIPFonNacEmpCont ;
            GXv_char13[0] = AV11ConAFIPLeyRieTrabCont ;
            GXv_char14[0] = AV10ConAFIPObraSocCont ;
            GXv_char15[0] = AV9ConAFIPRenateaApo ;
            GXv_char16[0] = AV24ConCodAfip ;
            new web.crearconceptoafipdefault3(remoteHandle, context).execute( A3CliCod, A26ConCodigo, GXv_char1, GXv_char2, GXv_char3, GXv_char4, GXv_char5, GXv_char6, GXv_char7, GXv_char8, GXv_char9, GXv_char10, GXv_char11, GXv_char12, GXv_char13, GXv_char14, GXv_char15, GXv_char16) ;
            inicializarconceptosafipdefault.this.AV23ConAFIPSIPAApo = GXv_char1[0] ;
            inicializarconceptosafipdefault.this.AV22ConAFIPINSSJyPCont = GXv_char2[0] ;
            inicializarconceptosafipdefault.this.AV21ConAFIPFonSolRedApo = GXv_char3[0] ;
            inicializarconceptosafipdefault.this.AV20ConAFIPFonSolRedCont = GXv_char4[0] ;
            inicializarconceptosafipdefault.this.AV19ConAFIPAsigFamCont = GXv_char5[0] ;
            inicializarconceptosafipdefault.this.AV18ConAFIPRegEspApo = GXv_char6[0] ;
            inicializarconceptosafipdefault.this.AV17ConAFIPRegDifApo = GXv_char7[0] ;
            inicializarconceptosafipdefault.this.AV16ConAFIPRenateaCont = GXv_char8[0] ;
            inicializarconceptosafipdefault.this.AV15ConAFIPSIPACont = GXv_char9[0] ;
            inicializarconceptosafipdefault.this.AV14ConAFIPINSSJyPApo = GXv_char10[0] ;
            inicializarconceptosafipdefault.this.AV13ConAFIPObraSocApo = GXv_char11[0] ;
            inicializarconceptosafipdefault.this.AV12ConAFIPFonNacEmpCont = GXv_char12[0] ;
            inicializarconceptosafipdefault.this.AV11ConAFIPLeyRieTrabCont = GXv_char13[0] ;
            inicializarconceptosafipdefault.this.AV10ConAFIPObraSocCont = GXv_char14[0] ;
            inicializarconceptosafipdefault.this.AV9ConAFIPRenateaApo = GXv_char15[0] ;
            inicializarconceptosafipdefault.this.AV24ConCodAfip = GXv_char16[0] ;
            if ( (GXutil.strcmp("", A1648ConCodAfip)==0) || P012X2_n1648ConCodAfip[0] )
            {
               A1648ConCodAfip = AV24ConCodAfip ;
            }
            A1472ConSIPAApo = (byte)(((GXutil.strcmp(AV23ConAFIPSIPAApo, "1")==0) ? 1 : 0)) ;
            A1473ConSIPACont = (byte)(((GXutil.strcmp(AV15ConAFIPSIPACont, "1")==0) ? 1 : 0)) ;
            A1474ConINSSJyPApo = (byte)(((GXutil.strcmp(AV14ConAFIPINSSJyPApo, "1")==0) ? 1 : 0)) ;
            A1475ConINSSJyPCont = (byte)(((GXutil.strcmp(AV22ConAFIPINSSJyPCont, "1")==0) ? 1 : 0)) ;
            A1476ConObraSocApo = (byte)(((GXutil.strcmp(AV13ConAFIPObraSocApo, "1")==0) ? 1 : 0)) ;
            A1477ConObraSocCont = (byte)(((GXutil.strcmp(AV10ConAFIPObraSocCont, "1")==0) ? 1 : 0)) ;
            A1478ConFonSolRedApo = (byte)(((GXutil.strcmp(AV21ConAFIPFonSolRedApo, "1")==0) ? 1 : 0)) ;
            A1479ConFonSolRedCont = (byte)(((GXutil.strcmp(AV20ConAFIPFonSolRedCont, "1")==0) ? 1 : 0)) ;
            A1480ConRenateaApo = (byte)(((GXutil.strcmp(AV9ConAFIPRenateaApo, "1")==0) ? 1 : 0)) ;
            A1481ConRenateaCont = (byte)(((GXutil.strcmp(AV16ConAFIPRenateaCont, "1")==0) ? 1 : 0)) ;
            A1482ConAsigFamCont = (byte)(((GXutil.strcmp(AV19ConAFIPAsigFamCont, "1")==0) ? 1 : 0)) ;
            A1483ConFonNacEmpCont = (byte)(((GXutil.strcmp(AV12ConAFIPFonNacEmpCont, "1")==0) ? 1 : 0)) ;
            A1484ConLeyRieTrabCont = (byte)(((GXutil.strcmp(AV11ConAFIPLeyRieTrabCont, "1")==0) ? 1 : 0)) ;
            A1485ConRegDifApo = (byte)(((GXutil.strcmp(AV17ConAFIPRegDifApo, "1")==0) ? 1 : 0)) ;
            A1486ConRegEspApo = (byte)(((GXutil.strcmp(AV18ConAFIPRegEspApo, "1")==0) ? 1 : 0)) ;
         }
         /* Using cursor P012X3 */
         pr_default.execute(1, new Object[] {A1648ConCodAfip, Byte.valueOf(A1472ConSIPAApo), Byte.valueOf(A1473ConSIPACont), Byte.valueOf(A1474ConINSSJyPApo), Byte.valueOf(A1475ConINSSJyPCont), Byte.valueOf(A1476ConObraSocApo), Byte.valueOf(A1477ConObraSocCont), Byte.valueOf(A1478ConFonSolRedApo), Byte.valueOf(A1479ConFonSolRedCont), Byte.valueOf(A1480ConRenateaApo), Byte.valueOf(A1481ConRenateaCont), Byte.valueOf(A1482ConAsigFamCont), Byte.valueOf(A1483ConFonNacEmpCont), Byte.valueOf(A1484ConLeyRieTrabCont), Byte.valueOf(A1485ConRegDifApo), Byte.valueOf(A1486ConRegEspApo), Integer.valueOf(A3CliCod), A26ConCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "inicializarconceptosafipdefault");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV28Pgmname = "" ;
      scmdbuf = "" ;
      A26ConCodigo = "" ;
      P012X2_A26ConCodigo = new String[] {""} ;
      P012X2_A3CliCod = new int[1] ;
      P012X2_A37TipoConCod = new String[] {""} ;
      P012X2_A1648ConCodAfip = new String[] {""} ;
      P012X2_A1472ConSIPAApo = new byte[1] ;
      P012X2_A1473ConSIPACont = new byte[1] ;
      P012X2_A1474ConINSSJyPApo = new byte[1] ;
      P012X2_A1475ConINSSJyPCont = new byte[1] ;
      P012X2_A1476ConObraSocApo = new byte[1] ;
      P012X2_A1477ConObraSocCont = new byte[1] ;
      P012X2_A1478ConFonSolRedApo = new byte[1] ;
      P012X2_A1479ConFonSolRedCont = new byte[1] ;
      P012X2_A1480ConRenateaApo = new byte[1] ;
      P012X2_A1481ConRenateaCont = new byte[1] ;
      P012X2_A1482ConAsigFamCont = new byte[1] ;
      P012X2_A1483ConFonNacEmpCont = new byte[1] ;
      P012X2_A1484ConLeyRieTrabCont = new byte[1] ;
      P012X2_A1485ConRegDifApo = new byte[1] ;
      P012X2_A1486ConRegEspApo = new byte[1] ;
      A37TipoConCod = "" ;
      A1648ConCodAfip = "" ;
      AV23ConAFIPSIPAApo = "" ;
      GXv_char1 = new String[1] ;
      AV22ConAFIPINSSJyPCont = "" ;
      GXv_char2 = new String[1] ;
      AV21ConAFIPFonSolRedApo = "" ;
      GXv_char3 = new String[1] ;
      AV20ConAFIPFonSolRedCont = "" ;
      GXv_char4 = new String[1] ;
      AV19ConAFIPAsigFamCont = "" ;
      GXv_char5 = new String[1] ;
      AV18ConAFIPRegEspApo = "" ;
      GXv_char6 = new String[1] ;
      AV17ConAFIPRegDifApo = "" ;
      GXv_char7 = new String[1] ;
      AV16ConAFIPRenateaCont = "" ;
      GXv_char8 = new String[1] ;
      AV15ConAFIPSIPACont = "" ;
      GXv_char9 = new String[1] ;
      AV14ConAFIPINSSJyPApo = "" ;
      GXv_char10 = new String[1] ;
      AV13ConAFIPObraSocApo = "" ;
      GXv_char11 = new String[1] ;
      AV12ConAFIPFonNacEmpCont = "" ;
      GXv_char12 = new String[1] ;
      AV11ConAFIPLeyRieTrabCont = "" ;
      GXv_char13 = new String[1] ;
      AV10ConAFIPObraSocCont = "" ;
      GXv_char14 = new String[1] ;
      AV9ConAFIPRenateaApo = "" ;
      GXv_char15 = new String[1] ;
      AV24ConCodAfip = "" ;
      GXv_char16 = new String[1] ;
      P012X2_n1648ConCodAfip = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.inicializarconceptosafipdefault__default(),
         new Object[] {
             new Object[] {
            P012X2_A26ConCodigo, P012X2_A3CliCod, P012X2_A37TipoConCod, P012X2_A1648ConCodAfip, P012X2_A1472ConSIPAApo, P012X2_A1473ConSIPACont, P012X2_A1474ConINSSJyPApo, P012X2_A1475ConINSSJyPCont, P012X2_A1476ConObraSocApo, P012X2_A1477ConObraSocCont,
            P012X2_A1478ConFonSolRedApo, P012X2_A1479ConFonSolRedCont, P012X2_A1480ConRenateaApo, P012X2_A1481ConRenateaCont, P012X2_A1482ConAsigFamCont, P012X2_A1483ConFonNacEmpCont, P012X2_A1484ConLeyRieTrabCont, P012X2_A1485ConRegDifApo, P012X2_A1486ConRegEspApo
            }
            , new Object[] {
            }
         }
      );
      AV28Pgmname = "inicializarConceptosAfipDefault" ;
      /* GeneXus formulas. */
      AV28Pgmname = "inicializarConceptosAfipDefault" ;
      Gx_err = (short)(0) ;
   }

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
   private String AV25ConCodigo ;
   private String AV28Pgmname ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String A37TipoConCod ;
   private String A1648ConCodAfip ;
   private String AV23ConAFIPSIPAApo ;
   private String GXv_char1[] ;
   private String AV22ConAFIPINSSJyPCont ;
   private String GXv_char2[] ;
   private String AV21ConAFIPFonSolRedApo ;
   private String GXv_char3[] ;
   private String AV20ConAFIPFonSolRedCont ;
   private String GXv_char4[] ;
   private String AV19ConAFIPAsigFamCont ;
   private String GXv_char5[] ;
   private String AV18ConAFIPRegEspApo ;
   private String GXv_char6[] ;
   private String AV17ConAFIPRegDifApo ;
   private String GXv_char7[] ;
   private String AV16ConAFIPRenateaCont ;
   private String GXv_char8[] ;
   private String AV15ConAFIPSIPACont ;
   private String GXv_char9[] ;
   private String AV14ConAFIPINSSJyPApo ;
   private String GXv_char10[] ;
   private String AV13ConAFIPObraSocApo ;
   private String GXv_char11[] ;
   private String AV12ConAFIPFonNacEmpCont ;
   private String GXv_char12[] ;
   private String AV11ConAFIPLeyRieTrabCont ;
   private String GXv_char13[] ;
   private String AV10ConAFIPObraSocCont ;
   private String GXv_char14[] ;
   private String AV9ConAFIPRenateaApo ;
   private String GXv_char15[] ;
   private String AV24ConCodAfip ;
   private String GXv_char16[] ;
   private IDataStoreProvider pr_default ;
   private String[] P012X2_A26ConCodigo ;
   private int[] P012X2_A3CliCod ;
   private String[] P012X2_A37TipoConCod ;
   private String[] P012X2_A1648ConCodAfip ;
   private byte[] P012X2_A1472ConSIPAApo ;
   private byte[] P012X2_A1473ConSIPACont ;
   private byte[] P012X2_A1474ConINSSJyPApo ;
   private byte[] P012X2_A1475ConINSSJyPCont ;
   private byte[] P012X2_A1476ConObraSocApo ;
   private byte[] P012X2_A1477ConObraSocCont ;
   private byte[] P012X2_A1478ConFonSolRedApo ;
   private byte[] P012X2_A1479ConFonSolRedCont ;
   private byte[] P012X2_A1480ConRenateaApo ;
   private byte[] P012X2_A1481ConRenateaCont ;
   private byte[] P012X2_A1482ConAsigFamCont ;
   private byte[] P012X2_A1483ConFonNacEmpCont ;
   private byte[] P012X2_A1484ConLeyRieTrabCont ;
   private byte[] P012X2_A1485ConRegDifApo ;
   private byte[] P012X2_A1486ConRegEspApo ;
   private boolean[] P012X2_n1648ConCodAfip ;
}

final  class inicializarconceptosafipdefault__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P012X2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV25ConCodigo ,
                                          String A26ConCodigo ,
                                          int AV8CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int17 = new byte[2];
      Object[] GXv_Object18 = new Object[2];
      scmdbuf = "SELECT ConCodigo, CliCod, TipoConCod, ConCodAfip, ConSIPAApo, ConSIPACont, ConINSSJyPApo, ConINSSJyPCont, ConObraSocApo, ConObraSocCont, ConFonSolRedApo, ConFonSolRedCont," ;
      scmdbuf += " ConRenateaApo, ConRenateaCont, ConAsigFamCont, ConFonNacEmpCont, ConLeyRieTrabCont, ConRegDifApo, ConRegEspApo FROM Concepto" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (GXutil.strcmp("", AV25ConCodigo)==0) )
      {
         addWhere(sWhereString, "(ConCodigo = ( ?))");
      }
      else
      {
         GXv_int17[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod" ;
      scmdbuf += " FOR UPDATE OF Concepto" ;
      GXv_Object18[0] = scmdbuf ;
      GXv_Object18[1] = GXv_int17 ;
      return GXv_Object18 ;
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
                  return conditional_P012X2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P012X2", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P012X3", "SAVEPOINT gxupdate;UPDATE Concepto SET ConCodAfip=?, ConSIPAApo=?, ConSIPACont=?, ConINSSJyPApo=?, ConINSSJyPCont=?, ConObraSocApo=?, ConObraSocCont=?, ConFonSolRedApo=?, ConFonSolRedCont=?, ConRenateaApo=?, ConRenateaCont=?, ConAsigFamCont=?, ConFonNacEmpCont=?, ConLeyRieTrabCont=?, ConRegDifApo=?, ConRegEspApo=?  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 6);
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
               ((byte[]) buf[17])[0] = rslt.getByte(18);
               ((byte[]) buf[18])[0] = rslt.getByte(19);
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
                  stmt.setInt(sIdx, ((Number) parms[2]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[3], 10);
               }
               return;
            case 1 :
               stmt.setString(1, (String)parms[0], 6);
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setByte(7, ((Number) parms[6]).byteValue());
               stmt.setByte(8, ((Number) parms[7]).byteValue());
               stmt.setByte(9, ((Number) parms[8]).byteValue());
               stmt.setByte(10, ((Number) parms[9]).byteValue());
               stmt.setByte(11, ((Number) parms[10]).byteValue());
               stmt.setByte(12, ((Number) parms[11]).byteValue());
               stmt.setByte(13, ((Number) parms[12]).byteValue());
               stmt.setByte(14, ((Number) parms[13]).byteValue());
               stmt.setByte(15, ((Number) parms[14]).byteValue());
               stmt.setByte(16, ((Number) parms[15]).byteValue());
               stmt.setInt(17, ((Number) parms[16]).intValue());
               stmt.setString(18, (String)parms[17], 10);
               return;
      }
   }

}

