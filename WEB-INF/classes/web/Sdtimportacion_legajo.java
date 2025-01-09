package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtimportacion_legajo extends GxSilentTrnSdt
{
   public Sdtimportacion_legajo( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(Sdtimportacion_legajo.class));
   }

   public Sdtimportacion_legajo( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle, context, "Sdtimportacion_legajo");
      initialize( remoteHandle) ;
   }

   public Sdtimportacion_legajo( int remoteHandle ,
                                 StructSdtimportacion_legajo struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public void Load( int AV3CliCod ,
                     short AV1EmpCod ,
                     int AV87MigrLegNumero )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV3CliCod),Short.valueOf(AV1EmpCod),Integer.valueOf(AV87MigrLegNumero)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CliCod", int.class}, new Object[]{"EmpCod", short.class}, new Object[]{"MigrLegNumero", int.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "importacion_legajo");
      metadata.set("BT", "importacion_legajo");
      metadata.set("PK", "[ \"CliCod\",\"EmpCod\",\"MigrLegNumero\" ]");
      metadata.set("PKAssigned", "[ \"CliCod\",\"EmpCod\" ]");
      metadata.set("Levels", "[ \"Familia\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\",\"EmpCod\" ],\"FKMap\":[  ] } ]");
      metadata.set("AllowInsert", "True");
      metadata.set("AllowUpdate", "True");
      metadata.set("AllowDelete", "True");
      return metadata ;
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod") )
            {
               gxTv_Sdtimportacion_legajo_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod") )
            {
               gxTv_Sdtimportacion_legajo_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegNumero") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegnumero = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegApellido") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegapellido = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegNombre") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegnombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFecNac") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtimportacion_legajo_Migrlegfecnac = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_Sdtimportacion_legajo_Migrlegfecnac = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegSexo") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegsexo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegEstadoCivil") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegestadocivil = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegCUIL") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegcuil = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegDiscapacidad") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegdiscapacidad = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegDomici") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegdomici = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegEmail") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegemail = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegCodPos") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegcodpos = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegTelefono") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegtelefono = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFecIngreso") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtimportacion_legajo_Migrlegfecingreso = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_Sdtimportacion_legajo_Migrlegfecingreso = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegCategoria") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegcategoria = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegArea") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegarea = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegLugarDePago") )
            {
               gxTv_Sdtimportacion_legajo_Migrleglugardepago = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegModTra") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegmodtra = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegTipoTarifa") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegtipotarifa = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegClase") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegclase = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegBasico") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegbasico = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFormaPago") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegformapago = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegClaseDef") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegclasedef = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegBanco") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegbanco = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegBanSuc") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegbansuc = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegBanTipCuen") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegbantipcuen = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegSindicato") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegsindicato = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegObraSocial") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegobrasocial = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegOSAfip") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegosafip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegPlanMedico") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegplanmedico = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegActividad") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegactividad = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegModalidad") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegmodalidad = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFecUltMod") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtimportacion_legajo_Migrlegfecultmod = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_Sdtimportacion_legajo_Migrlegfecultmod = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegCuentaBanc") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegcuentabanc = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegZona") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegzona = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegCBU") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegcbu = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegSCVO") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegscvo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegSituacionRevista") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegsituacionrevista = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegCondicion") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegcondicion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegSiniestrado") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegsiniestrado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegId") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegConvenio") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegconvenio = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegObs") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegobs = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegErrores") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegerrores = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegWarnings") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegwarnings = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrTieneConyuge") )
            {
               gxTv_Sdtimportacion_legajo_Migrtieneconyuge = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrCantidadHijos") )
            {
               gxTv_Sdtimportacion_legajo_Migrcantidadhijos = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrEncontroOsoSigla") )
            {
               gxTv_Sdtimportacion_legajo_Migrencontroososigla = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrTraDiurno") )
            {
               gxTv_Sdtimportacion_legajo_Migrtradiurno = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrTraNoct") )
            {
               gxTv_Sdtimportacion_legajo_Migrtranoct = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrTraIns") )
            {
               gxTv_Sdtimportacion_legajo_Migrtrains = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrEncontroOsoAfip") )
            {
               gxTv_Sdtimportacion_legajo_Migrencontroosoafip = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrSueldos") )
            {
               gxTv_Sdtimportacion_legajo_Migrsueldos = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrPeriodo") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtimportacion_legajo_Migrperiodo = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_Sdtimportacion_legajo_Migrperiodo = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegModalidadDef") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegmodalidaddef = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegZonaDef") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegzonadef = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegSituacionDef") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegsituaciondef = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegEstadoCivilDef") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegestadocivildef = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFormaPagoDef") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegformapagodef = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegTipoCuentaDef") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegtipocuentadef = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegActividadDef") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegactividaddef = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegCondicionDef") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegcondiciondef = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegSiniestradoDef") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegsiniestradodef = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrValCadaSave") )
            {
               gxTv_Sdtimportacion_legajo_Migrvalcadasave = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFecEgreso") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtimportacion_legajo_Migrlegfecegreso = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_Sdtimportacion_legajo_Migrlegfecegreso = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrOtrosDatos") )
            {
               gxTv_Sdtimportacion_legajo_Migrotrosdatos = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrPuesto") )
            {
               gxTv_Sdtimportacion_legajo_Migrpuesto = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegMarcaCCT") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegmarcacct = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrArchSec") )
            {
               gxTv_Sdtimportacion_legajo_Migrarchsec = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Familia") )
            {
               if ( gxTv_Sdtimportacion_legajo_Familia == null )
               {
                  gxTv_Sdtimportacion_legajo_Familia = new GXBCLevelCollection<web.Sdtimportacion_legajo_Familia>(web.Sdtimportacion_legajo_Familia.class, "importacion_legajo.Familia", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_Sdtimportacion_legajo_Familia.readxml(oReader, "Familia") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Familia") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegActLabClas") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegactlabclas = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegPueAfip") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegpueafip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegHorSem") )
            {
               gxTv_Sdtimportacion_legajo_Migrleghorsem = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_Sdtimportacion_legajo_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_Sdtimportacion_legajo_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_Sdtimportacion_legajo_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod_Z") )
            {
               gxTv_Sdtimportacion_legajo_Empcod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegNumero_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegnumero_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegApellido_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegapellido_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegNombre_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegnombre_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFecNac_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtimportacion_legajo_Migrlegfecnac_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_Sdtimportacion_legajo_Migrlegfecnac_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegSexo_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegsexo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegEstadoCivil_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegestadocivil_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegCUIL_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegcuil_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegDiscapacidad_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegdiscapacidad_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegDomici_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegdomici_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegEmail_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegemail_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegCodPos_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegcodpos_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegTelefono_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegtelefono_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFecIngreso_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtimportacion_legajo_Migrlegfecingreso_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_Sdtimportacion_legajo_Migrlegfecingreso_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegCategoria_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegcategoria_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegArea_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegarea_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegLugarDePago_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrleglugardepago_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegModTra_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegmodtra_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegTipoTarifa_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegtipotarifa_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegClase_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegclase_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegBasico_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegbasico_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFormaPago_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegformapago_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegClaseDef_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegclasedef_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegBanco_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegbanco_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegBanSuc_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegbansuc_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegBanTipCuen_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegbantipcuen_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegSindicato_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegsindicato_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegObraSocial_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegobrasocial_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegOSAfip_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegosafip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegPlanMedico_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegplanmedico_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegActividad_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegactividad_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegModalidad_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegmodalidad_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFecUltMod_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtimportacion_legajo_Migrlegfecultmod_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_Sdtimportacion_legajo_Migrlegfecultmod_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegCuentaBanc_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegcuentabanc_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegZona_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegzona_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegCBU_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegcbu_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegSCVO_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegscvo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegSituacionRevista_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegsituacionrevista_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegCondicion_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegcondicion_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegSiniestrado_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegsiniestrado_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegId_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegid_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegConvenio_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegconvenio_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrTieneConyuge_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrtieneconyuge_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrCantidadHijos_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrcantidadhijos_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrEncontroOsoSigla_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrencontroososigla_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrTraDiurno_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrtradiurno_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrTraNoct_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrtranoct_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrTraIns_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrtrains_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrEncontroOsoAfip_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrencontroosoafip_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrPeriodo_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtimportacion_legajo_Migrperiodo_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_Sdtimportacion_legajo_Migrperiodo_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegModalidadDef_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegmodalidaddef_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegZonaDef_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegzonadef_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegSituacionDef_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegsituaciondef_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegEstadoCivilDef_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegestadocivildef_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFormaPagoDef_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegformapagodef_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegTipoCuentaDef_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegtipocuentadef_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegActividadDef_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegactividaddef_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegCondicionDef_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegcondiciondef_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegSiniestradoDef_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegsiniestradodef_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrValCadaSave_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrvalcadasave_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFecEgreso_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtimportacion_legajo_Migrlegfecegreso_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_Sdtimportacion_legajo_Migrlegfecegreso_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrPuesto_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrpuesto_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegMarcaCCT_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegmarcacct_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrArchSec_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrarchsec_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegActLabClas_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegactlabclas_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegPueAfip_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegpueafip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegHorSem_Z") )
            {
               gxTv_Sdtimportacion_legajo_Migrleghorsem_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegMarcaCCT_N") )
            {
               gxTv_Sdtimportacion_legajo_Migrlegmarcacct_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrArchSec_N") )
            {
               gxTv_Sdtimportacion_legajo_Migrarchsec_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "importacion_legajo" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "PayDay" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_legajo_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCod", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_legajo_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegNumero", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_legajo_Migrlegnumero, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegApellido", gxTv_Sdtimportacion_legajo_Migrlegapellido);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegNombre", gxTv_Sdtimportacion_legajo_Migrlegnombre);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajo_Migrlegfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajo_Migrlegfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajo_Migrlegfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("MigrLegFecNac", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegSexo", gxTv_Sdtimportacion_legajo_Migrlegsexo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegEstadoCivil", gxTv_Sdtimportacion_legajo_Migrlegestadocivil);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegCUIL", gxTv_Sdtimportacion_legajo_Migrlegcuil);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegDiscapacidad", gxTv_Sdtimportacion_legajo_Migrlegdiscapacidad);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegDomici", gxTv_Sdtimportacion_legajo_Migrlegdomici);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegEmail", gxTv_Sdtimportacion_legajo_Migrlegemail);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegCodPos", gxTv_Sdtimportacion_legajo_Migrlegcodpos);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegTelefono", gxTv_Sdtimportacion_legajo_Migrlegtelefono);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajo_Migrlegfecingreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajo_Migrlegfecingreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajo_Migrlegfecingreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("MigrLegFecIngreso", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegCategoria", gxTv_Sdtimportacion_legajo_Migrlegcategoria);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegArea", gxTv_Sdtimportacion_legajo_Migrlegarea);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegLugarDePago", gxTv_Sdtimportacion_legajo_Migrleglugardepago);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegModTra", gxTv_Sdtimportacion_legajo_Migrlegmodtra);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegTipoTarifa", gxTv_Sdtimportacion_legajo_Migrlegtipotarifa);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegClase", gxTv_Sdtimportacion_legajo_Migrlegclase);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegBasico", GXutil.trim( GXutil.strNoRound( gxTv_Sdtimportacion_legajo_Migrlegbasico, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegFormaPago", gxTv_Sdtimportacion_legajo_Migrlegformapago);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegClaseDef", GXutil.booltostr( gxTv_Sdtimportacion_legajo_Migrlegclasedef));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegBanco", gxTv_Sdtimportacion_legajo_Migrlegbanco);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegBanSuc", gxTv_Sdtimportacion_legajo_Migrlegbansuc);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegBanTipCuen", gxTv_Sdtimportacion_legajo_Migrlegbantipcuen);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegSindicato", gxTv_Sdtimportacion_legajo_Migrlegsindicato);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegObraSocial", gxTv_Sdtimportacion_legajo_Migrlegobrasocial);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegOSAfip", gxTv_Sdtimportacion_legajo_Migrlegosafip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegPlanMedico", gxTv_Sdtimportacion_legajo_Migrlegplanmedico);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegActividad", gxTv_Sdtimportacion_legajo_Migrlegactividad);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegModalidad", gxTv_Sdtimportacion_legajo_Migrlegmodalidad);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajo_Migrlegfecultmod), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajo_Migrlegfecultmod), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajo_Migrlegfecultmod), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("MigrLegFecUltMod", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegCuentaBanc", gxTv_Sdtimportacion_legajo_Migrlegcuentabanc);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegZona", gxTv_Sdtimportacion_legajo_Migrlegzona);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegCBU", gxTv_Sdtimportacion_legajo_Migrlegcbu);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegSCVO", gxTv_Sdtimportacion_legajo_Migrlegscvo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegSituacionRevista", gxTv_Sdtimportacion_legajo_Migrlegsituacionrevista);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegCondicion", gxTv_Sdtimportacion_legajo_Migrlegcondicion);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegSiniestrado", gxTv_Sdtimportacion_legajo_Migrlegsiniestrado);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegId", gxTv_Sdtimportacion_legajo_Migrlegid);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegConvenio", gxTv_Sdtimportacion_legajo_Migrlegconvenio);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegObs", gxTv_Sdtimportacion_legajo_Migrlegobs);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegErrores", gxTv_Sdtimportacion_legajo_Migrlegerrores);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegWarnings", gxTv_Sdtimportacion_legajo_Migrlegwarnings);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrTieneConyuge", gxTv_Sdtimportacion_legajo_Migrtieneconyuge);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrCantidadHijos", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_legajo_Migrcantidadhijos, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrEncontroOsoSigla", GXutil.booltostr( gxTv_Sdtimportacion_legajo_Migrencontroososigla));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrTraDiurno", gxTv_Sdtimportacion_legajo_Migrtradiurno);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrTraNoct", gxTv_Sdtimportacion_legajo_Migrtranoct);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrTraIns", gxTv_Sdtimportacion_legajo_Migrtrains);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrEncontroOsoAfip", GXutil.booltostr( gxTv_Sdtimportacion_legajo_Migrencontroosoafip));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrSueldos", gxTv_Sdtimportacion_legajo_Migrsueldos);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajo_Migrperiodo), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajo_Migrperiodo), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajo_Migrperiodo), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("MigrPeriodo", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegModalidadDef", GXutil.booltostr( gxTv_Sdtimportacion_legajo_Migrlegmodalidaddef));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegZonaDef", GXutil.booltostr( gxTv_Sdtimportacion_legajo_Migrlegzonadef));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegSituacionDef", GXutil.booltostr( gxTv_Sdtimportacion_legajo_Migrlegsituaciondef));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegEstadoCivilDef", GXutil.booltostr( gxTv_Sdtimportacion_legajo_Migrlegestadocivildef));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegFormaPagoDef", GXutil.booltostr( gxTv_Sdtimportacion_legajo_Migrlegformapagodef));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegTipoCuentaDef", GXutil.booltostr( gxTv_Sdtimportacion_legajo_Migrlegtipocuentadef));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegActividadDef", GXutil.booltostr( gxTv_Sdtimportacion_legajo_Migrlegactividaddef));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegCondicionDef", GXutil.booltostr( gxTv_Sdtimportacion_legajo_Migrlegcondiciondef));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegSiniestradoDef", GXutil.booltostr( gxTv_Sdtimportacion_legajo_Migrlegsiniestradodef));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrValCadaSave", GXutil.booltostr( gxTv_Sdtimportacion_legajo_Migrvalcadasave));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajo_Migrlegfecegreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajo_Migrlegfecegreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajo_Migrlegfecegreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("MigrLegFecEgreso", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrOtrosDatos", gxTv_Sdtimportacion_legajo_Migrotrosdatos);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrPuesto", gxTv_Sdtimportacion_legajo_Migrpuesto);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegMarcaCCT", gxTv_Sdtimportacion_legajo_Migrlegmarcacct);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrArchSec", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_legajo_Migrarchsec, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_Sdtimportacion_legajo_Familia != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "PayDay") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "PayDay" ;
         }
         else
         {
            sNameSpace1 = "PayDay" ;
         }
         gxTv_Sdtimportacion_legajo_Familia.writexml(oWriter, "Familia", sNameSpace1, sIncludeState);
      }
      oWriter.writeElement("MigrLegActLabClas", gxTv_Sdtimportacion_legajo_Migrlegactlabclas);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegPueAfip", gxTv_Sdtimportacion_legajo_Migrlegpueafip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegHorSem", GXutil.trim( GXutil.strNoRound( gxTv_Sdtimportacion_legajo_Migrleghorsem, 4, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_Sdtimportacion_legajo_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_legajo_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_legajo_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpCod_Z", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_legajo_Empcod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegNumero_Z", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_legajo_Migrlegnumero_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegApellido_Z", gxTv_Sdtimportacion_legajo_Migrlegapellido_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegNombre_Z", gxTv_Sdtimportacion_legajo_Migrlegnombre_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajo_Migrlegfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajo_Migrlegfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajo_Migrlegfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("MigrLegFecNac_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegSexo_Z", gxTv_Sdtimportacion_legajo_Migrlegsexo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegEstadoCivil_Z", gxTv_Sdtimportacion_legajo_Migrlegestadocivil_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegCUIL_Z", gxTv_Sdtimportacion_legajo_Migrlegcuil_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegDiscapacidad_Z", gxTv_Sdtimportacion_legajo_Migrlegdiscapacidad_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegDomici_Z", gxTv_Sdtimportacion_legajo_Migrlegdomici_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegEmail_Z", gxTv_Sdtimportacion_legajo_Migrlegemail_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegCodPos_Z", gxTv_Sdtimportacion_legajo_Migrlegcodpos_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegTelefono_Z", gxTv_Sdtimportacion_legajo_Migrlegtelefono_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajo_Migrlegfecingreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajo_Migrlegfecingreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajo_Migrlegfecingreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("MigrLegFecIngreso_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegCategoria_Z", gxTv_Sdtimportacion_legajo_Migrlegcategoria_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegArea_Z", gxTv_Sdtimportacion_legajo_Migrlegarea_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegLugarDePago_Z", gxTv_Sdtimportacion_legajo_Migrleglugardepago_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegModTra_Z", gxTv_Sdtimportacion_legajo_Migrlegmodtra_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegTipoTarifa_Z", gxTv_Sdtimportacion_legajo_Migrlegtipotarifa_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegClase_Z", gxTv_Sdtimportacion_legajo_Migrlegclase_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegBasico_Z", GXutil.trim( GXutil.strNoRound( gxTv_Sdtimportacion_legajo_Migrlegbasico_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegFormaPago_Z", gxTv_Sdtimportacion_legajo_Migrlegformapago_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegClaseDef_Z", GXutil.booltostr( gxTv_Sdtimportacion_legajo_Migrlegclasedef_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegBanco_Z", gxTv_Sdtimportacion_legajo_Migrlegbanco_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegBanSuc_Z", gxTv_Sdtimportacion_legajo_Migrlegbansuc_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegBanTipCuen_Z", gxTv_Sdtimportacion_legajo_Migrlegbantipcuen_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegSindicato_Z", gxTv_Sdtimportacion_legajo_Migrlegsindicato_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegObraSocial_Z", gxTv_Sdtimportacion_legajo_Migrlegobrasocial_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegOSAfip_Z", gxTv_Sdtimportacion_legajo_Migrlegosafip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegPlanMedico_Z", gxTv_Sdtimportacion_legajo_Migrlegplanmedico_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegActividad_Z", gxTv_Sdtimportacion_legajo_Migrlegactividad_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegModalidad_Z", gxTv_Sdtimportacion_legajo_Migrlegmodalidad_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajo_Migrlegfecultmod_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajo_Migrlegfecultmod_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajo_Migrlegfecultmod_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("MigrLegFecUltMod_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegCuentaBanc_Z", gxTv_Sdtimportacion_legajo_Migrlegcuentabanc_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegZona_Z", gxTv_Sdtimportacion_legajo_Migrlegzona_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegCBU_Z", gxTv_Sdtimportacion_legajo_Migrlegcbu_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegSCVO_Z", gxTv_Sdtimportacion_legajo_Migrlegscvo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegSituacionRevista_Z", gxTv_Sdtimportacion_legajo_Migrlegsituacionrevista_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegCondicion_Z", gxTv_Sdtimportacion_legajo_Migrlegcondicion_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegSiniestrado_Z", gxTv_Sdtimportacion_legajo_Migrlegsiniestrado_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegId_Z", gxTv_Sdtimportacion_legajo_Migrlegid_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegConvenio_Z", gxTv_Sdtimportacion_legajo_Migrlegconvenio_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrTieneConyuge_Z", gxTv_Sdtimportacion_legajo_Migrtieneconyuge_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrCantidadHijos_Z", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_legajo_Migrcantidadhijos_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrEncontroOsoSigla_Z", GXutil.booltostr( gxTv_Sdtimportacion_legajo_Migrencontroososigla_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrTraDiurno_Z", gxTv_Sdtimportacion_legajo_Migrtradiurno_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrTraNoct_Z", gxTv_Sdtimportacion_legajo_Migrtranoct_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrTraIns_Z", gxTv_Sdtimportacion_legajo_Migrtrains_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrEncontroOsoAfip_Z", GXutil.booltostr( gxTv_Sdtimportacion_legajo_Migrencontroosoafip_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajo_Migrperiodo_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajo_Migrperiodo_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajo_Migrperiodo_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("MigrPeriodo_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegModalidadDef_Z", GXutil.booltostr( gxTv_Sdtimportacion_legajo_Migrlegmodalidaddef_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegZonaDef_Z", GXutil.booltostr( gxTv_Sdtimportacion_legajo_Migrlegzonadef_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegSituacionDef_Z", GXutil.booltostr( gxTv_Sdtimportacion_legajo_Migrlegsituaciondef_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegEstadoCivilDef_Z", GXutil.booltostr( gxTv_Sdtimportacion_legajo_Migrlegestadocivildef_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegFormaPagoDef_Z", GXutil.booltostr( gxTv_Sdtimportacion_legajo_Migrlegformapagodef_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegTipoCuentaDef_Z", GXutil.booltostr( gxTv_Sdtimportacion_legajo_Migrlegtipocuentadef_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegActividadDef_Z", GXutil.booltostr( gxTv_Sdtimportacion_legajo_Migrlegactividaddef_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegCondicionDef_Z", GXutil.booltostr( gxTv_Sdtimportacion_legajo_Migrlegcondiciondef_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegSiniestradoDef_Z", GXutil.booltostr( gxTv_Sdtimportacion_legajo_Migrlegsiniestradodef_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrValCadaSave_Z", GXutil.booltostr( gxTv_Sdtimportacion_legajo_Migrvalcadasave_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajo_Migrlegfecegreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajo_Migrlegfecegreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajo_Migrlegfecegreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("MigrLegFecEgreso_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrPuesto_Z", gxTv_Sdtimportacion_legajo_Migrpuesto_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegMarcaCCT_Z", gxTv_Sdtimportacion_legajo_Migrlegmarcacct_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrArchSec_Z", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_legajo_Migrarchsec_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegActLabClas_Z", gxTv_Sdtimportacion_legajo_Migrlegactlabclas_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegPueAfip_Z", gxTv_Sdtimportacion_legajo_Migrlegpueafip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegHorSem_Z", GXutil.trim( GXutil.strNoRound( gxTv_Sdtimportacion_legajo_Migrleghorsem_Z, 4, 1)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegMarcaCCT_N", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_legajo_Migrlegmarcacct_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrArchSec_N", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_legajo_Migrarchsec_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("CliCod", gxTv_Sdtimportacion_legajo_Clicod, false, includeNonInitialized);
      AddObjectProperty("EmpCod", gxTv_Sdtimportacion_legajo_Empcod, false, includeNonInitialized);
      AddObjectProperty("MigrLegNumero", gxTv_Sdtimportacion_legajo_Migrlegnumero, false, includeNonInitialized);
      AddObjectProperty("MigrLegApellido", gxTv_Sdtimportacion_legajo_Migrlegapellido, false, includeNonInitialized);
      AddObjectProperty("MigrLegNombre", gxTv_Sdtimportacion_legajo_Migrlegnombre, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajo_Migrlegfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajo_Migrlegfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajo_Migrlegfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("MigrLegFecNac", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("MigrLegSexo", gxTv_Sdtimportacion_legajo_Migrlegsexo, false, includeNonInitialized);
      AddObjectProperty("MigrLegEstadoCivil", gxTv_Sdtimportacion_legajo_Migrlegestadocivil, false, includeNonInitialized);
      AddObjectProperty("MigrLegCUIL", gxTv_Sdtimportacion_legajo_Migrlegcuil, false, includeNonInitialized);
      AddObjectProperty("MigrLegDiscapacidad", gxTv_Sdtimportacion_legajo_Migrlegdiscapacidad, false, includeNonInitialized);
      AddObjectProperty("MigrLegDomici", gxTv_Sdtimportacion_legajo_Migrlegdomici, false, includeNonInitialized);
      AddObjectProperty("MigrLegEmail", gxTv_Sdtimportacion_legajo_Migrlegemail, false, includeNonInitialized);
      AddObjectProperty("MigrLegCodPos", gxTv_Sdtimportacion_legajo_Migrlegcodpos, false, includeNonInitialized);
      AddObjectProperty("MigrLegTelefono", gxTv_Sdtimportacion_legajo_Migrlegtelefono, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajo_Migrlegfecingreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajo_Migrlegfecingreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajo_Migrlegfecingreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("MigrLegFecIngreso", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("MigrLegCategoria", gxTv_Sdtimportacion_legajo_Migrlegcategoria, false, includeNonInitialized);
      AddObjectProperty("MigrLegArea", gxTv_Sdtimportacion_legajo_Migrlegarea, false, includeNonInitialized);
      AddObjectProperty("MigrLegLugarDePago", gxTv_Sdtimportacion_legajo_Migrleglugardepago, false, includeNonInitialized);
      AddObjectProperty("MigrLegModTra", gxTv_Sdtimportacion_legajo_Migrlegmodtra, false, includeNonInitialized);
      AddObjectProperty("MigrLegTipoTarifa", gxTv_Sdtimportacion_legajo_Migrlegtipotarifa, false, includeNonInitialized);
      AddObjectProperty("MigrLegClase", gxTv_Sdtimportacion_legajo_Migrlegclase, false, includeNonInitialized);
      AddObjectProperty("MigrLegBasico", gxTv_Sdtimportacion_legajo_Migrlegbasico, false, includeNonInitialized);
      AddObjectProperty("MigrLegFormaPago", gxTv_Sdtimportacion_legajo_Migrlegformapago, false, includeNonInitialized);
      AddObjectProperty("MigrLegClaseDef", gxTv_Sdtimportacion_legajo_Migrlegclasedef, false, includeNonInitialized);
      AddObjectProperty("MigrLegBanco", gxTv_Sdtimportacion_legajo_Migrlegbanco, false, includeNonInitialized);
      AddObjectProperty("MigrLegBanSuc", gxTv_Sdtimportacion_legajo_Migrlegbansuc, false, includeNonInitialized);
      AddObjectProperty("MigrLegBanTipCuen", gxTv_Sdtimportacion_legajo_Migrlegbantipcuen, false, includeNonInitialized);
      AddObjectProperty("MigrLegSindicato", gxTv_Sdtimportacion_legajo_Migrlegsindicato, false, includeNonInitialized);
      AddObjectProperty("MigrLegObraSocial", gxTv_Sdtimportacion_legajo_Migrlegobrasocial, false, includeNonInitialized);
      AddObjectProperty("MigrLegOSAfip", gxTv_Sdtimportacion_legajo_Migrlegosafip, false, includeNonInitialized);
      AddObjectProperty("MigrLegPlanMedico", gxTv_Sdtimportacion_legajo_Migrlegplanmedico, false, includeNonInitialized);
      AddObjectProperty("MigrLegActividad", gxTv_Sdtimportacion_legajo_Migrlegactividad, false, includeNonInitialized);
      AddObjectProperty("MigrLegModalidad", gxTv_Sdtimportacion_legajo_Migrlegmodalidad, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajo_Migrlegfecultmod), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajo_Migrlegfecultmod), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajo_Migrlegfecultmod), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("MigrLegFecUltMod", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("MigrLegCuentaBanc", gxTv_Sdtimportacion_legajo_Migrlegcuentabanc, false, includeNonInitialized);
      AddObjectProperty("MigrLegZona", gxTv_Sdtimportacion_legajo_Migrlegzona, false, includeNonInitialized);
      AddObjectProperty("MigrLegCBU", gxTv_Sdtimportacion_legajo_Migrlegcbu, false, includeNonInitialized);
      AddObjectProperty("MigrLegSCVO", gxTv_Sdtimportacion_legajo_Migrlegscvo, false, includeNonInitialized);
      AddObjectProperty("MigrLegSituacionRevista", gxTv_Sdtimportacion_legajo_Migrlegsituacionrevista, false, includeNonInitialized);
      AddObjectProperty("MigrLegCondicion", gxTv_Sdtimportacion_legajo_Migrlegcondicion, false, includeNonInitialized);
      AddObjectProperty("MigrLegSiniestrado", gxTv_Sdtimportacion_legajo_Migrlegsiniestrado, false, includeNonInitialized);
      AddObjectProperty("MigrLegId", gxTv_Sdtimportacion_legajo_Migrlegid, false, includeNonInitialized);
      AddObjectProperty("MigrLegConvenio", gxTv_Sdtimportacion_legajo_Migrlegconvenio, false, includeNonInitialized);
      AddObjectProperty("MigrLegObs", gxTv_Sdtimportacion_legajo_Migrlegobs, false, includeNonInitialized);
      AddObjectProperty("MigrLegErrores", gxTv_Sdtimportacion_legajo_Migrlegerrores, false, includeNonInitialized);
      AddObjectProperty("MigrLegWarnings", gxTv_Sdtimportacion_legajo_Migrlegwarnings, false, includeNonInitialized);
      AddObjectProperty("MigrTieneConyuge", gxTv_Sdtimportacion_legajo_Migrtieneconyuge, false, includeNonInitialized);
      AddObjectProperty("MigrCantidadHijos", gxTv_Sdtimportacion_legajo_Migrcantidadhijos, false, includeNonInitialized);
      AddObjectProperty("MigrEncontroOsoSigla", gxTv_Sdtimportacion_legajo_Migrencontroososigla, false, includeNonInitialized);
      AddObjectProperty("MigrTraDiurno", gxTv_Sdtimportacion_legajo_Migrtradiurno, false, includeNonInitialized);
      AddObjectProperty("MigrTraNoct", gxTv_Sdtimportacion_legajo_Migrtranoct, false, includeNonInitialized);
      AddObjectProperty("MigrTraIns", gxTv_Sdtimportacion_legajo_Migrtrains, false, includeNonInitialized);
      AddObjectProperty("MigrEncontroOsoAfip", gxTv_Sdtimportacion_legajo_Migrencontroosoafip, false, includeNonInitialized);
      AddObjectProperty("MigrSueldos", gxTv_Sdtimportacion_legajo_Migrsueldos, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajo_Migrperiodo), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajo_Migrperiodo), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajo_Migrperiodo), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("MigrPeriodo", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("MigrLegModalidadDef", gxTv_Sdtimportacion_legajo_Migrlegmodalidaddef, false, includeNonInitialized);
      AddObjectProperty("MigrLegZonaDef", gxTv_Sdtimportacion_legajo_Migrlegzonadef, false, includeNonInitialized);
      AddObjectProperty("MigrLegSituacionDef", gxTv_Sdtimportacion_legajo_Migrlegsituaciondef, false, includeNonInitialized);
      AddObjectProperty("MigrLegEstadoCivilDef", gxTv_Sdtimportacion_legajo_Migrlegestadocivildef, false, includeNonInitialized);
      AddObjectProperty("MigrLegFormaPagoDef", gxTv_Sdtimportacion_legajo_Migrlegformapagodef, false, includeNonInitialized);
      AddObjectProperty("MigrLegTipoCuentaDef", gxTv_Sdtimportacion_legajo_Migrlegtipocuentadef, false, includeNonInitialized);
      AddObjectProperty("MigrLegActividadDef", gxTv_Sdtimportacion_legajo_Migrlegactividaddef, false, includeNonInitialized);
      AddObjectProperty("MigrLegCondicionDef", gxTv_Sdtimportacion_legajo_Migrlegcondiciondef, false, includeNonInitialized);
      AddObjectProperty("MigrLegSiniestradoDef", gxTv_Sdtimportacion_legajo_Migrlegsiniestradodef, false, includeNonInitialized);
      AddObjectProperty("MigrValCadaSave", gxTv_Sdtimportacion_legajo_Migrvalcadasave, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajo_Migrlegfecegreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajo_Migrlegfecegreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajo_Migrlegfecegreso), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("MigrLegFecEgreso", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("MigrOtrosDatos", gxTv_Sdtimportacion_legajo_Migrotrosdatos, false, includeNonInitialized);
      AddObjectProperty("MigrPuesto", gxTv_Sdtimportacion_legajo_Migrpuesto, false, includeNonInitialized);
      AddObjectProperty("MigrLegMarcaCCT", gxTv_Sdtimportacion_legajo_Migrlegmarcacct, false, includeNonInitialized);
      AddObjectProperty("MigrLegMarcaCCT_N", gxTv_Sdtimportacion_legajo_Migrlegmarcacct_N, false, includeNonInitialized);
      AddObjectProperty("MigrArchSec", gxTv_Sdtimportacion_legajo_Migrarchsec, false, includeNonInitialized);
      AddObjectProperty("MigrArchSec_N", gxTv_Sdtimportacion_legajo_Migrarchsec_N, false, includeNonInitialized);
      if ( gxTv_Sdtimportacion_legajo_Familia != null )
      {
         AddObjectProperty("Familia", gxTv_Sdtimportacion_legajo_Familia, includeState, includeNonInitialized);
      }
      AddObjectProperty("MigrLegActLabClas", gxTv_Sdtimportacion_legajo_Migrlegactlabclas, false, includeNonInitialized);
      AddObjectProperty("MigrLegPueAfip", gxTv_Sdtimportacion_legajo_Migrlegpueafip, false, includeNonInitialized);
      AddObjectProperty("MigrLegHorSem", gxTv_Sdtimportacion_legajo_Migrleghorsem, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_Sdtimportacion_legajo_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_Sdtimportacion_legajo_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_Sdtimportacion_legajo_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpCod_Z", gxTv_Sdtimportacion_legajo_Empcod_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegNumero_Z", gxTv_Sdtimportacion_legajo_Migrlegnumero_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegApellido_Z", gxTv_Sdtimportacion_legajo_Migrlegapellido_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegNombre_Z", gxTv_Sdtimportacion_legajo_Migrlegnombre_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajo_Migrlegfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajo_Migrlegfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajo_Migrlegfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("MigrLegFecNac_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("MigrLegSexo_Z", gxTv_Sdtimportacion_legajo_Migrlegsexo_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegEstadoCivil_Z", gxTv_Sdtimportacion_legajo_Migrlegestadocivil_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegCUIL_Z", gxTv_Sdtimportacion_legajo_Migrlegcuil_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegDiscapacidad_Z", gxTv_Sdtimportacion_legajo_Migrlegdiscapacidad_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegDomici_Z", gxTv_Sdtimportacion_legajo_Migrlegdomici_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegEmail_Z", gxTv_Sdtimportacion_legajo_Migrlegemail_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegCodPos_Z", gxTv_Sdtimportacion_legajo_Migrlegcodpos_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegTelefono_Z", gxTv_Sdtimportacion_legajo_Migrlegtelefono_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajo_Migrlegfecingreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajo_Migrlegfecingreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajo_Migrlegfecingreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("MigrLegFecIngreso_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("MigrLegCategoria_Z", gxTv_Sdtimportacion_legajo_Migrlegcategoria_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegArea_Z", gxTv_Sdtimportacion_legajo_Migrlegarea_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegLugarDePago_Z", gxTv_Sdtimportacion_legajo_Migrleglugardepago_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegModTra_Z", gxTv_Sdtimportacion_legajo_Migrlegmodtra_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegTipoTarifa_Z", gxTv_Sdtimportacion_legajo_Migrlegtipotarifa_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegClase_Z", gxTv_Sdtimportacion_legajo_Migrlegclase_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegBasico_Z", gxTv_Sdtimportacion_legajo_Migrlegbasico_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegFormaPago_Z", gxTv_Sdtimportacion_legajo_Migrlegformapago_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegClaseDef_Z", gxTv_Sdtimportacion_legajo_Migrlegclasedef_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegBanco_Z", gxTv_Sdtimportacion_legajo_Migrlegbanco_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegBanSuc_Z", gxTv_Sdtimportacion_legajo_Migrlegbansuc_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegBanTipCuen_Z", gxTv_Sdtimportacion_legajo_Migrlegbantipcuen_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegSindicato_Z", gxTv_Sdtimportacion_legajo_Migrlegsindicato_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegObraSocial_Z", gxTv_Sdtimportacion_legajo_Migrlegobrasocial_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegOSAfip_Z", gxTv_Sdtimportacion_legajo_Migrlegosafip_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegPlanMedico_Z", gxTv_Sdtimportacion_legajo_Migrlegplanmedico_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegActividad_Z", gxTv_Sdtimportacion_legajo_Migrlegactividad_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegModalidad_Z", gxTv_Sdtimportacion_legajo_Migrlegmodalidad_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajo_Migrlegfecultmod_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajo_Migrlegfecultmod_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajo_Migrlegfecultmod_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("MigrLegFecUltMod_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("MigrLegCuentaBanc_Z", gxTv_Sdtimportacion_legajo_Migrlegcuentabanc_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegZona_Z", gxTv_Sdtimportacion_legajo_Migrlegzona_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegCBU_Z", gxTv_Sdtimportacion_legajo_Migrlegcbu_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegSCVO_Z", gxTv_Sdtimportacion_legajo_Migrlegscvo_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegSituacionRevista_Z", gxTv_Sdtimportacion_legajo_Migrlegsituacionrevista_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegCondicion_Z", gxTv_Sdtimportacion_legajo_Migrlegcondicion_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegSiniestrado_Z", gxTv_Sdtimportacion_legajo_Migrlegsiniestrado_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegId_Z", gxTv_Sdtimportacion_legajo_Migrlegid_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegConvenio_Z", gxTv_Sdtimportacion_legajo_Migrlegconvenio_Z, false, includeNonInitialized);
         AddObjectProperty("MigrTieneConyuge_Z", gxTv_Sdtimportacion_legajo_Migrtieneconyuge_Z, false, includeNonInitialized);
         AddObjectProperty("MigrCantidadHijos_Z", gxTv_Sdtimportacion_legajo_Migrcantidadhijos_Z, false, includeNonInitialized);
         AddObjectProperty("MigrEncontroOsoSigla_Z", gxTv_Sdtimportacion_legajo_Migrencontroososigla_Z, false, includeNonInitialized);
         AddObjectProperty("MigrTraDiurno_Z", gxTv_Sdtimportacion_legajo_Migrtradiurno_Z, false, includeNonInitialized);
         AddObjectProperty("MigrTraNoct_Z", gxTv_Sdtimportacion_legajo_Migrtranoct_Z, false, includeNonInitialized);
         AddObjectProperty("MigrTraIns_Z", gxTv_Sdtimportacion_legajo_Migrtrains_Z, false, includeNonInitialized);
         AddObjectProperty("MigrEncontroOsoAfip_Z", gxTv_Sdtimportacion_legajo_Migrencontroosoafip_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajo_Migrperiodo_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajo_Migrperiodo_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajo_Migrperiodo_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("MigrPeriodo_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("MigrLegModalidadDef_Z", gxTv_Sdtimportacion_legajo_Migrlegmodalidaddef_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegZonaDef_Z", gxTv_Sdtimportacion_legajo_Migrlegzonadef_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegSituacionDef_Z", gxTv_Sdtimportacion_legajo_Migrlegsituaciondef_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegEstadoCivilDef_Z", gxTv_Sdtimportacion_legajo_Migrlegestadocivildef_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegFormaPagoDef_Z", gxTv_Sdtimportacion_legajo_Migrlegformapagodef_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegTipoCuentaDef_Z", gxTv_Sdtimportacion_legajo_Migrlegtipocuentadef_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegActividadDef_Z", gxTv_Sdtimportacion_legajo_Migrlegactividaddef_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegCondicionDef_Z", gxTv_Sdtimportacion_legajo_Migrlegcondiciondef_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegSiniestradoDef_Z", gxTv_Sdtimportacion_legajo_Migrlegsiniestradodef_Z, false, includeNonInitialized);
         AddObjectProperty("MigrValCadaSave_Z", gxTv_Sdtimportacion_legajo_Migrvalcadasave_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajo_Migrlegfecegreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajo_Migrlegfecegreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajo_Migrlegfecegreso_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("MigrLegFecEgreso_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("MigrPuesto_Z", gxTv_Sdtimportacion_legajo_Migrpuesto_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegMarcaCCT_Z", gxTv_Sdtimportacion_legajo_Migrlegmarcacct_Z, false, includeNonInitialized);
         AddObjectProperty("MigrArchSec_Z", gxTv_Sdtimportacion_legajo_Migrarchsec_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegActLabClas_Z", gxTv_Sdtimportacion_legajo_Migrlegactlabclas_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegPueAfip_Z", gxTv_Sdtimportacion_legajo_Migrlegpueafip_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegHorSem_Z", gxTv_Sdtimportacion_legajo_Migrleghorsem_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegMarcaCCT_N", gxTv_Sdtimportacion_legajo_Migrlegmarcacct_N, false, includeNonInitialized);
         AddObjectProperty("MigrArchSec_N", gxTv_Sdtimportacion_legajo_Migrarchsec_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.Sdtimportacion_legajo sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Clicod = sdt.getgxTv_Sdtimportacion_legajo_Clicod() ;
      }
      if ( sdt.IsDirty("EmpCod") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Empcod = sdt.getgxTv_Sdtimportacion_legajo_Empcod() ;
      }
      if ( sdt.IsDirty("MigrLegNumero") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegnumero = sdt.getgxTv_Sdtimportacion_legajo_Migrlegnumero() ;
      }
      if ( sdt.IsDirty("MigrLegApellido") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegapellido = sdt.getgxTv_Sdtimportacion_legajo_Migrlegapellido() ;
      }
      if ( sdt.IsDirty("MigrLegNombre") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegnombre = sdt.getgxTv_Sdtimportacion_legajo_Migrlegnombre() ;
      }
      if ( sdt.IsDirty("MigrLegFecNac") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegfecnac = sdt.getgxTv_Sdtimportacion_legajo_Migrlegfecnac() ;
      }
      if ( sdt.IsDirty("MigrLegSexo") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegsexo = sdt.getgxTv_Sdtimportacion_legajo_Migrlegsexo() ;
      }
      if ( sdt.IsDirty("MigrLegEstadoCivil") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegestadocivil = sdt.getgxTv_Sdtimportacion_legajo_Migrlegestadocivil() ;
      }
      if ( sdt.IsDirty("MigrLegCUIL") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegcuil = sdt.getgxTv_Sdtimportacion_legajo_Migrlegcuil() ;
      }
      if ( sdt.IsDirty("MigrLegDiscapacidad") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegdiscapacidad = sdt.getgxTv_Sdtimportacion_legajo_Migrlegdiscapacidad() ;
      }
      if ( sdt.IsDirty("MigrLegDomici") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegdomici = sdt.getgxTv_Sdtimportacion_legajo_Migrlegdomici() ;
      }
      if ( sdt.IsDirty("MigrLegEmail") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegemail = sdt.getgxTv_Sdtimportacion_legajo_Migrlegemail() ;
      }
      if ( sdt.IsDirty("MigrLegCodPos") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegcodpos = sdt.getgxTv_Sdtimportacion_legajo_Migrlegcodpos() ;
      }
      if ( sdt.IsDirty("MigrLegTelefono") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegtelefono = sdt.getgxTv_Sdtimportacion_legajo_Migrlegtelefono() ;
      }
      if ( sdt.IsDirty("MigrLegFecIngreso") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegfecingreso = sdt.getgxTv_Sdtimportacion_legajo_Migrlegfecingreso() ;
      }
      if ( sdt.IsDirty("MigrLegCategoria") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegcategoria = sdt.getgxTv_Sdtimportacion_legajo_Migrlegcategoria() ;
      }
      if ( sdt.IsDirty("MigrLegArea") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegarea = sdt.getgxTv_Sdtimportacion_legajo_Migrlegarea() ;
      }
      if ( sdt.IsDirty("MigrLegLugarDePago") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrleglugardepago = sdt.getgxTv_Sdtimportacion_legajo_Migrleglugardepago() ;
      }
      if ( sdt.IsDirty("MigrLegModTra") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegmodtra = sdt.getgxTv_Sdtimportacion_legajo_Migrlegmodtra() ;
      }
      if ( sdt.IsDirty("MigrLegTipoTarifa") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegtipotarifa = sdt.getgxTv_Sdtimportacion_legajo_Migrlegtipotarifa() ;
      }
      if ( sdt.IsDirty("MigrLegClase") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegclase = sdt.getgxTv_Sdtimportacion_legajo_Migrlegclase() ;
      }
      if ( sdt.IsDirty("MigrLegBasico") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegbasico = sdt.getgxTv_Sdtimportacion_legajo_Migrlegbasico() ;
      }
      if ( sdt.IsDirty("MigrLegFormaPago") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegformapago = sdt.getgxTv_Sdtimportacion_legajo_Migrlegformapago() ;
      }
      if ( sdt.IsDirty("MigrLegClaseDef") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegclasedef = sdt.getgxTv_Sdtimportacion_legajo_Migrlegclasedef() ;
      }
      if ( sdt.IsDirty("MigrLegBanco") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegbanco = sdt.getgxTv_Sdtimportacion_legajo_Migrlegbanco() ;
      }
      if ( sdt.IsDirty("MigrLegBanSuc") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegbansuc = sdt.getgxTv_Sdtimportacion_legajo_Migrlegbansuc() ;
      }
      if ( sdt.IsDirty("MigrLegBanTipCuen") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegbantipcuen = sdt.getgxTv_Sdtimportacion_legajo_Migrlegbantipcuen() ;
      }
      if ( sdt.IsDirty("MigrLegSindicato") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegsindicato = sdt.getgxTv_Sdtimportacion_legajo_Migrlegsindicato() ;
      }
      if ( sdt.IsDirty("MigrLegObraSocial") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegobrasocial = sdt.getgxTv_Sdtimportacion_legajo_Migrlegobrasocial() ;
      }
      if ( sdt.IsDirty("MigrLegOSAfip") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegosafip = sdt.getgxTv_Sdtimportacion_legajo_Migrlegosafip() ;
      }
      if ( sdt.IsDirty("MigrLegPlanMedico") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegplanmedico = sdt.getgxTv_Sdtimportacion_legajo_Migrlegplanmedico() ;
      }
      if ( sdt.IsDirty("MigrLegActividad") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegactividad = sdt.getgxTv_Sdtimportacion_legajo_Migrlegactividad() ;
      }
      if ( sdt.IsDirty("MigrLegModalidad") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegmodalidad = sdt.getgxTv_Sdtimportacion_legajo_Migrlegmodalidad() ;
      }
      if ( sdt.IsDirty("MigrLegFecUltMod") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegfecultmod = sdt.getgxTv_Sdtimportacion_legajo_Migrlegfecultmod() ;
      }
      if ( sdt.IsDirty("MigrLegCuentaBanc") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegcuentabanc = sdt.getgxTv_Sdtimportacion_legajo_Migrlegcuentabanc() ;
      }
      if ( sdt.IsDirty("MigrLegZona") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegzona = sdt.getgxTv_Sdtimportacion_legajo_Migrlegzona() ;
      }
      if ( sdt.IsDirty("MigrLegCBU") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegcbu = sdt.getgxTv_Sdtimportacion_legajo_Migrlegcbu() ;
      }
      if ( sdt.IsDirty("MigrLegSCVO") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegscvo = sdt.getgxTv_Sdtimportacion_legajo_Migrlegscvo() ;
      }
      if ( sdt.IsDirty("MigrLegSituacionRevista") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegsituacionrevista = sdt.getgxTv_Sdtimportacion_legajo_Migrlegsituacionrevista() ;
      }
      if ( sdt.IsDirty("MigrLegCondicion") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegcondicion = sdt.getgxTv_Sdtimportacion_legajo_Migrlegcondicion() ;
      }
      if ( sdt.IsDirty("MigrLegSiniestrado") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegsiniestrado = sdt.getgxTv_Sdtimportacion_legajo_Migrlegsiniestrado() ;
      }
      if ( sdt.IsDirty("MigrLegId") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegid = sdt.getgxTv_Sdtimportacion_legajo_Migrlegid() ;
      }
      if ( sdt.IsDirty("MigrLegConvenio") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegconvenio = sdt.getgxTv_Sdtimportacion_legajo_Migrlegconvenio() ;
      }
      if ( sdt.IsDirty("MigrLegObs") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegobs = sdt.getgxTv_Sdtimportacion_legajo_Migrlegobs() ;
      }
      if ( sdt.IsDirty("MigrLegErrores") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegerrores = sdt.getgxTv_Sdtimportacion_legajo_Migrlegerrores() ;
      }
      if ( sdt.IsDirty("MigrLegWarnings") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegwarnings = sdt.getgxTv_Sdtimportacion_legajo_Migrlegwarnings() ;
      }
      if ( sdt.IsDirty("MigrTieneConyuge") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrtieneconyuge = sdt.getgxTv_Sdtimportacion_legajo_Migrtieneconyuge() ;
      }
      if ( sdt.IsDirty("MigrCantidadHijos") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrcantidadhijos = sdt.getgxTv_Sdtimportacion_legajo_Migrcantidadhijos() ;
      }
      if ( sdt.IsDirty("MigrEncontroOsoSigla") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrencontroososigla = sdt.getgxTv_Sdtimportacion_legajo_Migrencontroososigla() ;
      }
      if ( sdt.IsDirty("MigrTraDiurno") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrtradiurno = sdt.getgxTv_Sdtimportacion_legajo_Migrtradiurno() ;
      }
      if ( sdt.IsDirty("MigrTraNoct") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrtranoct = sdt.getgxTv_Sdtimportacion_legajo_Migrtranoct() ;
      }
      if ( sdt.IsDirty("MigrTraIns") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrtrains = sdt.getgxTv_Sdtimportacion_legajo_Migrtrains() ;
      }
      if ( sdt.IsDirty("MigrEncontroOsoAfip") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrencontroosoafip = sdt.getgxTv_Sdtimportacion_legajo_Migrencontroosoafip() ;
      }
      if ( sdt.IsDirty("MigrSueldos") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrsueldos = sdt.getgxTv_Sdtimportacion_legajo_Migrsueldos() ;
      }
      if ( sdt.IsDirty("MigrPeriodo") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrperiodo = sdt.getgxTv_Sdtimportacion_legajo_Migrperiodo() ;
      }
      if ( sdt.IsDirty("MigrLegModalidadDef") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegmodalidaddef = sdt.getgxTv_Sdtimportacion_legajo_Migrlegmodalidaddef() ;
      }
      if ( sdt.IsDirty("MigrLegZonaDef") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegzonadef = sdt.getgxTv_Sdtimportacion_legajo_Migrlegzonadef() ;
      }
      if ( sdt.IsDirty("MigrLegSituacionDef") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegsituaciondef = sdt.getgxTv_Sdtimportacion_legajo_Migrlegsituaciondef() ;
      }
      if ( sdt.IsDirty("MigrLegEstadoCivilDef") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegestadocivildef = sdt.getgxTv_Sdtimportacion_legajo_Migrlegestadocivildef() ;
      }
      if ( sdt.IsDirty("MigrLegFormaPagoDef") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegformapagodef = sdt.getgxTv_Sdtimportacion_legajo_Migrlegformapagodef() ;
      }
      if ( sdt.IsDirty("MigrLegTipoCuentaDef") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegtipocuentadef = sdt.getgxTv_Sdtimportacion_legajo_Migrlegtipocuentadef() ;
      }
      if ( sdt.IsDirty("MigrLegActividadDef") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegactividaddef = sdt.getgxTv_Sdtimportacion_legajo_Migrlegactividaddef() ;
      }
      if ( sdt.IsDirty("MigrLegCondicionDef") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegcondiciondef = sdt.getgxTv_Sdtimportacion_legajo_Migrlegcondiciondef() ;
      }
      if ( sdt.IsDirty("MigrLegSiniestradoDef") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegsiniestradodef = sdt.getgxTv_Sdtimportacion_legajo_Migrlegsiniestradodef() ;
      }
      if ( sdt.IsDirty("MigrValCadaSave") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrvalcadasave = sdt.getgxTv_Sdtimportacion_legajo_Migrvalcadasave() ;
      }
      if ( sdt.IsDirty("MigrLegFecEgreso") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegfecegreso = sdt.getgxTv_Sdtimportacion_legajo_Migrlegfecegreso() ;
      }
      if ( sdt.IsDirty("MigrOtrosDatos") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrotrosdatos = sdt.getgxTv_Sdtimportacion_legajo_Migrotrosdatos() ;
      }
      if ( sdt.IsDirty("MigrPuesto") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrpuesto = sdt.getgxTv_Sdtimportacion_legajo_Migrpuesto() ;
      }
      if ( sdt.IsDirty("MigrLegMarcaCCT") )
      {
         gxTv_Sdtimportacion_legajo_Migrlegmarcacct_N = sdt.getgxTv_Sdtimportacion_legajo_Migrlegmarcacct_N() ;
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegmarcacct = sdt.getgxTv_Sdtimportacion_legajo_Migrlegmarcacct() ;
      }
      if ( sdt.IsDirty("MigrArchSec") )
      {
         gxTv_Sdtimportacion_legajo_Migrarchsec_N = sdt.getgxTv_Sdtimportacion_legajo_Migrarchsec_N() ;
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrarchsec = sdt.getgxTv_Sdtimportacion_legajo_Migrarchsec() ;
      }
      if ( gxTv_Sdtimportacion_legajo_Familia != null )
      {
         GXBCLevelCollection<web.Sdtimportacion_legajo_Familia> newCollectionFamilia = sdt.getgxTv_Sdtimportacion_legajo_Familia();
         web.Sdtimportacion_legajo_Familia currItemFamilia;
         web.Sdtimportacion_legajo_Familia newItemFamilia;
         short idx = 1;
         while ( idx <= newCollectionFamilia.size() )
         {
            newItemFamilia = (web.Sdtimportacion_legajo_Familia)((web.Sdtimportacion_legajo_Familia)newCollectionFamilia.elementAt(-1+idx));
            currItemFamilia = (web.Sdtimportacion_legajo_Familia)gxTv_Sdtimportacion_legajo_Familia.getByKey(newItemFamilia.getgxTv_Sdtimportacion_legajo_Familia_Migrlegfamsec());
            if ( GXutil.strcmp(currItemFamilia.getgxTv_Sdtimportacion_legajo_Familia_Mode(), "UPD") == 0 )
            {
               currItemFamilia.updateDirties(newItemFamilia);
               if ( GXutil.strcmp(newItemFamilia.getgxTv_Sdtimportacion_legajo_Familia_Mode(), "DLT") == 0 )
               {
                  currItemFamilia.setgxTv_Sdtimportacion_legajo_Familia_Mode( "DLT" );
               }
               currItemFamilia.setgxTv_Sdtimportacion_legajo_Familia_Modified( (short)(1) );
            }
            else
            {
               gxTv_Sdtimportacion_legajo_Familia.add(newItemFamilia, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
      if ( sdt.IsDirty("MigrLegActLabClas") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegactlabclas = sdt.getgxTv_Sdtimportacion_legajo_Migrlegactlabclas() ;
      }
      if ( sdt.IsDirty("MigrLegPueAfip") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrlegpueafip = sdt.getgxTv_Sdtimportacion_legajo_Migrlegpueafip() ;
      }
      if ( sdt.IsDirty("MigrLegHorSem") )
      {
         gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajo_Migrleghorsem = sdt.getgxTv_Sdtimportacion_legajo_Migrleghorsem() ;
      }
   }

   public int getgxTv_Sdtimportacion_legajo_Clicod( )
   {
      return gxTv_Sdtimportacion_legajo_Clicod ;
   }

   public void setgxTv_Sdtimportacion_legajo_Clicod( int value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      if ( gxTv_Sdtimportacion_legajo_Clicod != value )
      {
         gxTv_Sdtimportacion_legajo_Mode = "INS" ;
         this.setgxTv_Sdtimportacion_legajo_Clicod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Empcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegnumero_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegapellido_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegnombre_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegfecnac_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegsexo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegestadocivil_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegcuil_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegdiscapacidad_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegdomici_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegemail_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegcodpos_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegtelefono_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegfecingreso_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegcategoria_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegarea_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrleglugardepago_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegmodtra_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegtipotarifa_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegclase_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegbasico_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegformapago_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegclasedef_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegbanco_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegbansuc_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegbantipcuen_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegsindicato_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegobrasocial_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegosafip_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegplanmedico_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegactividad_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegmodalidad_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegfecultmod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegcuentabanc_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegzona_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegcbu_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegscvo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegsituacionrevista_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegcondicion_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegsiniestrado_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegid_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegconvenio_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrtieneconyuge_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrcantidadhijos_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrencontroososigla_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrtradiurno_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrtranoct_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrtrains_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrencontroosoafip_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrperiodo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegmodalidaddef_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegzonadef_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegsituaciondef_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegestadocivildef_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegformapagodef_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegtipocuentadef_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegactividaddef_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegcondiciondef_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegsiniestradodef_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrvalcadasave_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegfecegreso_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrpuesto_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegmarcacct_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrarchsec_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegactlabclas_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegpueafip_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrleghorsem_Z_SetNull( );
         if ( gxTv_Sdtimportacion_legajo_Familia != null )
         {
            GXBCLevelCollection<web.Sdtimportacion_legajo_Familia> collectionFamilia = gxTv_Sdtimportacion_legajo_Familia;
            web.Sdtimportacion_legajo_Familia currItemFamilia;
            short idx = 1;
            while ( idx <= collectionFamilia.size() )
            {
               currItemFamilia = (web.Sdtimportacion_legajo_Familia)((web.Sdtimportacion_legajo_Familia)collectionFamilia.elementAt(-1+idx));
               currItemFamilia.setgxTv_Sdtimportacion_legajo_Familia_Mode( "INS" );
               currItemFamilia.setgxTv_Sdtimportacion_legajo_Familia_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Clicod");
      gxTv_Sdtimportacion_legajo_Clicod = value ;
   }

   public short getgxTv_Sdtimportacion_legajo_Empcod( )
   {
      return gxTv_Sdtimportacion_legajo_Empcod ;
   }

   public void setgxTv_Sdtimportacion_legajo_Empcod( short value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      if ( gxTv_Sdtimportacion_legajo_Empcod != value )
      {
         gxTv_Sdtimportacion_legajo_Mode = "INS" ;
         this.setgxTv_Sdtimportacion_legajo_Clicod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Empcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegnumero_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegapellido_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegnombre_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegfecnac_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegsexo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegestadocivil_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegcuil_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegdiscapacidad_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegdomici_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegemail_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegcodpos_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegtelefono_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegfecingreso_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegcategoria_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegarea_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrleglugardepago_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegmodtra_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegtipotarifa_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegclase_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegbasico_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegformapago_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegclasedef_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegbanco_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegbansuc_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegbantipcuen_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegsindicato_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegobrasocial_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegosafip_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegplanmedico_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegactividad_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegmodalidad_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegfecultmod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegcuentabanc_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegzona_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegcbu_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegscvo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegsituacionrevista_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegcondicion_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegsiniestrado_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegid_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegconvenio_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrtieneconyuge_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrcantidadhijos_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrencontroososigla_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrtradiurno_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrtranoct_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrtrains_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrencontroosoafip_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrperiodo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegmodalidaddef_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegzonadef_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegsituaciondef_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegestadocivildef_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegformapagodef_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegtipocuentadef_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegactividaddef_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegcondiciondef_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegsiniestradodef_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrvalcadasave_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegfecegreso_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrpuesto_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegmarcacct_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrarchsec_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegactlabclas_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegpueafip_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrleghorsem_Z_SetNull( );
         if ( gxTv_Sdtimportacion_legajo_Familia != null )
         {
            GXBCLevelCollection<web.Sdtimportacion_legajo_Familia> collectionFamilia = gxTv_Sdtimportacion_legajo_Familia;
            web.Sdtimportacion_legajo_Familia currItemFamilia;
            short idx = 1;
            while ( idx <= collectionFamilia.size() )
            {
               currItemFamilia = (web.Sdtimportacion_legajo_Familia)((web.Sdtimportacion_legajo_Familia)collectionFamilia.elementAt(-1+idx));
               currItemFamilia.setgxTv_Sdtimportacion_legajo_Familia_Mode( "INS" );
               currItemFamilia.setgxTv_Sdtimportacion_legajo_Familia_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Empcod");
      gxTv_Sdtimportacion_legajo_Empcod = value ;
   }

   public int getgxTv_Sdtimportacion_legajo_Migrlegnumero( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegnumero ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegnumero( int value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      if ( gxTv_Sdtimportacion_legajo_Migrlegnumero != value )
      {
         gxTv_Sdtimportacion_legajo_Mode = "INS" ;
         this.setgxTv_Sdtimportacion_legajo_Clicod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Empcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegnumero_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegapellido_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegnombre_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegfecnac_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegsexo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegestadocivil_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegcuil_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegdiscapacidad_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegdomici_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegemail_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegcodpos_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegtelefono_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegfecingreso_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegcategoria_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegarea_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrleglugardepago_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegmodtra_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegtipotarifa_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegclase_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegbasico_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegformapago_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegclasedef_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegbanco_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegbansuc_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegbantipcuen_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegsindicato_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegobrasocial_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegosafip_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegplanmedico_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegactividad_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegmodalidad_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegfecultmod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegcuentabanc_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegzona_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegcbu_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegscvo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegsituacionrevista_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegcondicion_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegsiniestrado_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegid_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegconvenio_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrtieneconyuge_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrcantidadhijos_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrencontroososigla_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrtradiurno_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrtranoct_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrtrains_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrencontroosoafip_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrperiodo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegmodalidaddef_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegzonadef_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegsituaciondef_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegestadocivildef_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegformapagodef_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegtipocuentadef_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegactividaddef_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegcondiciondef_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegsiniestradodef_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrvalcadasave_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegfecegreso_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrpuesto_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegmarcacct_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrarchsec_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegactlabclas_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrlegpueafip_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajo_Migrleghorsem_Z_SetNull( );
         if ( gxTv_Sdtimportacion_legajo_Familia != null )
         {
            GXBCLevelCollection<web.Sdtimportacion_legajo_Familia> collectionFamilia = gxTv_Sdtimportacion_legajo_Familia;
            web.Sdtimportacion_legajo_Familia currItemFamilia;
            short idx = 1;
            while ( idx <= collectionFamilia.size() )
            {
               currItemFamilia = (web.Sdtimportacion_legajo_Familia)((web.Sdtimportacion_legajo_Familia)collectionFamilia.elementAt(-1+idx));
               currItemFamilia.setgxTv_Sdtimportacion_legajo_Familia_Mode( "INS" );
               currItemFamilia.setgxTv_Sdtimportacion_legajo_Familia_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Migrlegnumero");
      gxTv_Sdtimportacion_legajo_Migrlegnumero = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegapellido( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegapellido ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegapellido( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegapellido");
      gxTv_Sdtimportacion_legajo_Migrlegapellido = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegnombre( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegnombre ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegnombre( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegnombre");
      gxTv_Sdtimportacion_legajo_Migrlegnombre = value ;
   }

   public java.util.Date getgxTv_Sdtimportacion_legajo_Migrlegfecnac( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegfecnac ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegfecnac( java.util.Date value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegfecnac");
      gxTv_Sdtimportacion_legajo_Migrlegfecnac = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegsexo( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegsexo ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegsexo( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegsexo");
      gxTv_Sdtimportacion_legajo_Migrlegsexo = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegestadocivil( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegestadocivil ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegestadocivil( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegestadocivil");
      gxTv_Sdtimportacion_legajo_Migrlegestadocivil = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegcuil( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegcuil ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegcuil( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegcuil");
      gxTv_Sdtimportacion_legajo_Migrlegcuil = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegdiscapacidad( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegdiscapacidad ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegdiscapacidad( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegdiscapacidad");
      gxTv_Sdtimportacion_legajo_Migrlegdiscapacidad = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegdomici( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegdomici ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegdomici( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegdomici");
      gxTv_Sdtimportacion_legajo_Migrlegdomici = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegemail( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegemail ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegemail( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegemail");
      gxTv_Sdtimportacion_legajo_Migrlegemail = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegcodpos( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegcodpos ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegcodpos( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegcodpos");
      gxTv_Sdtimportacion_legajo_Migrlegcodpos = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegtelefono( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegtelefono ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegtelefono( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegtelefono");
      gxTv_Sdtimportacion_legajo_Migrlegtelefono = value ;
   }

   public java.util.Date getgxTv_Sdtimportacion_legajo_Migrlegfecingreso( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegfecingreso ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegfecingreso( java.util.Date value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegfecingreso");
      gxTv_Sdtimportacion_legajo_Migrlegfecingreso = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegcategoria( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegcategoria ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegcategoria( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegcategoria");
      gxTv_Sdtimportacion_legajo_Migrlegcategoria = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegarea( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegarea ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegarea( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegarea");
      gxTv_Sdtimportacion_legajo_Migrlegarea = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrleglugardepago( )
   {
      return gxTv_Sdtimportacion_legajo_Migrleglugardepago ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrleglugardepago( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrleglugardepago");
      gxTv_Sdtimportacion_legajo_Migrleglugardepago = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegmodtra( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegmodtra ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegmodtra( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegmodtra");
      gxTv_Sdtimportacion_legajo_Migrlegmodtra = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegtipotarifa( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegtipotarifa ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegtipotarifa( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegtipotarifa");
      gxTv_Sdtimportacion_legajo_Migrlegtipotarifa = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegclase( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegclase ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegclase( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegclase");
      gxTv_Sdtimportacion_legajo_Migrlegclase = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtimportacion_legajo_Migrlegbasico( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegbasico ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegbasico( java.math.BigDecimal value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegbasico");
      gxTv_Sdtimportacion_legajo_Migrlegbasico = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegformapago( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegformapago ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegformapago( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegformapago");
      gxTv_Sdtimportacion_legajo_Migrlegformapago = value ;
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegclasedef( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegclasedef ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegclasedef( boolean value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegclasedef");
      gxTv_Sdtimportacion_legajo_Migrlegclasedef = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegbanco( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegbanco ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegbanco( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegbanco");
      gxTv_Sdtimportacion_legajo_Migrlegbanco = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegbansuc( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegbansuc ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegbansuc( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegbansuc");
      gxTv_Sdtimportacion_legajo_Migrlegbansuc = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegbantipcuen( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegbantipcuen ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegbantipcuen( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegbantipcuen");
      gxTv_Sdtimportacion_legajo_Migrlegbantipcuen = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegsindicato( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegsindicato ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegsindicato( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegsindicato");
      gxTv_Sdtimportacion_legajo_Migrlegsindicato = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegobrasocial( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegobrasocial ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegobrasocial( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegobrasocial");
      gxTv_Sdtimportacion_legajo_Migrlegobrasocial = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegosafip( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegosafip ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegosafip( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegosafip");
      gxTv_Sdtimportacion_legajo_Migrlegosafip = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegplanmedico( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegplanmedico ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegplanmedico( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegplanmedico");
      gxTv_Sdtimportacion_legajo_Migrlegplanmedico = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegactividad( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegactividad ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegactividad( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegactividad");
      gxTv_Sdtimportacion_legajo_Migrlegactividad = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegmodalidad( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegmodalidad ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegmodalidad( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegmodalidad");
      gxTv_Sdtimportacion_legajo_Migrlegmodalidad = value ;
   }

   public java.util.Date getgxTv_Sdtimportacion_legajo_Migrlegfecultmod( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegfecultmod ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegfecultmod( java.util.Date value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegfecultmod");
      gxTv_Sdtimportacion_legajo_Migrlegfecultmod = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegcuentabanc( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegcuentabanc ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegcuentabanc( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegcuentabanc");
      gxTv_Sdtimportacion_legajo_Migrlegcuentabanc = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegzona( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegzona ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegzona( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegzona");
      gxTv_Sdtimportacion_legajo_Migrlegzona = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegcbu( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegcbu ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegcbu( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegcbu");
      gxTv_Sdtimportacion_legajo_Migrlegcbu = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegscvo( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegscvo ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegscvo( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegscvo");
      gxTv_Sdtimportacion_legajo_Migrlegscvo = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegsituacionrevista( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegsituacionrevista ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegsituacionrevista( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegsituacionrevista");
      gxTv_Sdtimportacion_legajo_Migrlegsituacionrevista = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegcondicion( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegcondicion ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegcondicion( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegcondicion");
      gxTv_Sdtimportacion_legajo_Migrlegcondicion = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegsiniestrado( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegsiniestrado ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegsiniestrado( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegsiniestrado");
      gxTv_Sdtimportacion_legajo_Migrlegsiniestrado = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegid( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegid ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegid( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegid");
      gxTv_Sdtimportacion_legajo_Migrlegid = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegconvenio( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegconvenio ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegconvenio( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegconvenio");
      gxTv_Sdtimportacion_legajo_Migrlegconvenio = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegobs( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegobs ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegobs( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegobs");
      gxTv_Sdtimportacion_legajo_Migrlegobs = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegerrores( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegerrores ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegerrores( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegerrores");
      gxTv_Sdtimportacion_legajo_Migrlegerrores = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegwarnings( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegwarnings ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegwarnings( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegwarnings");
      gxTv_Sdtimportacion_legajo_Migrlegwarnings = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrtieneconyuge( )
   {
      return gxTv_Sdtimportacion_legajo_Migrtieneconyuge ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrtieneconyuge( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrtieneconyuge");
      gxTv_Sdtimportacion_legajo_Migrtieneconyuge = value ;
   }

   public short getgxTv_Sdtimportacion_legajo_Migrcantidadhijos( )
   {
      return gxTv_Sdtimportacion_legajo_Migrcantidadhijos ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrcantidadhijos( short value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrcantidadhijos");
      gxTv_Sdtimportacion_legajo_Migrcantidadhijos = value ;
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrencontroososigla( )
   {
      return gxTv_Sdtimportacion_legajo_Migrencontroososigla ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrencontroososigla( boolean value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrencontroososigla");
      gxTv_Sdtimportacion_legajo_Migrencontroososigla = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrtradiurno( )
   {
      return gxTv_Sdtimportacion_legajo_Migrtradiurno ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrtradiurno( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrtradiurno");
      gxTv_Sdtimportacion_legajo_Migrtradiurno = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrtranoct( )
   {
      return gxTv_Sdtimportacion_legajo_Migrtranoct ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrtranoct( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrtranoct");
      gxTv_Sdtimportacion_legajo_Migrtranoct = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrtrains( )
   {
      return gxTv_Sdtimportacion_legajo_Migrtrains ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrtrains( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrtrains");
      gxTv_Sdtimportacion_legajo_Migrtrains = value ;
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrencontroosoafip( )
   {
      return gxTv_Sdtimportacion_legajo_Migrencontroosoafip ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrencontroosoafip( boolean value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrencontroosoafip");
      gxTv_Sdtimportacion_legajo_Migrencontroosoafip = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrsueldos( )
   {
      return gxTv_Sdtimportacion_legajo_Migrsueldos ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrsueldos( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrsueldos");
      gxTv_Sdtimportacion_legajo_Migrsueldos = value ;
   }

   public java.util.Date getgxTv_Sdtimportacion_legajo_Migrperiodo( )
   {
      return gxTv_Sdtimportacion_legajo_Migrperiodo ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrperiodo( java.util.Date value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrperiodo");
      gxTv_Sdtimportacion_legajo_Migrperiodo = value ;
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegmodalidaddef( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegmodalidaddef ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegmodalidaddef( boolean value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegmodalidaddef");
      gxTv_Sdtimportacion_legajo_Migrlegmodalidaddef = value ;
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegzonadef( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegzonadef ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegzonadef( boolean value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegzonadef");
      gxTv_Sdtimportacion_legajo_Migrlegzonadef = value ;
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegsituaciondef( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegsituaciondef ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegsituaciondef( boolean value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegsituaciondef");
      gxTv_Sdtimportacion_legajo_Migrlegsituaciondef = value ;
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegestadocivildef( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegestadocivildef ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegestadocivildef( boolean value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegestadocivildef");
      gxTv_Sdtimportacion_legajo_Migrlegestadocivildef = value ;
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegformapagodef( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegformapagodef ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegformapagodef( boolean value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegformapagodef");
      gxTv_Sdtimportacion_legajo_Migrlegformapagodef = value ;
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegtipocuentadef( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegtipocuentadef ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegtipocuentadef( boolean value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegtipocuentadef");
      gxTv_Sdtimportacion_legajo_Migrlegtipocuentadef = value ;
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegactividaddef( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegactividaddef ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegactividaddef( boolean value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegactividaddef");
      gxTv_Sdtimportacion_legajo_Migrlegactividaddef = value ;
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegcondiciondef( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegcondiciondef ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegcondiciondef( boolean value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegcondiciondef");
      gxTv_Sdtimportacion_legajo_Migrlegcondiciondef = value ;
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegsiniestradodef( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegsiniestradodef ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegsiniestradodef( boolean value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegsiniestradodef");
      gxTv_Sdtimportacion_legajo_Migrlegsiniestradodef = value ;
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrvalcadasave( )
   {
      return gxTv_Sdtimportacion_legajo_Migrvalcadasave ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrvalcadasave( boolean value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrvalcadasave");
      gxTv_Sdtimportacion_legajo_Migrvalcadasave = value ;
   }

   public java.util.Date getgxTv_Sdtimportacion_legajo_Migrlegfecegreso( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegfecegreso ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegfecegreso( java.util.Date value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegfecegreso");
      gxTv_Sdtimportacion_legajo_Migrlegfecegreso = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrotrosdatos( )
   {
      return gxTv_Sdtimportacion_legajo_Migrotrosdatos ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrotrosdatos( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrotrosdatos");
      gxTv_Sdtimportacion_legajo_Migrotrosdatos = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrpuesto( )
   {
      return gxTv_Sdtimportacion_legajo_Migrpuesto ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrpuesto( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrpuesto");
      gxTv_Sdtimportacion_legajo_Migrpuesto = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegmarcacct( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegmarcacct ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegmarcacct( String value )
   {
      gxTv_Sdtimportacion_legajo_Migrlegmarcacct_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegmarcacct");
      gxTv_Sdtimportacion_legajo_Migrlegmarcacct = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegmarcacct_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegmarcacct_N = (byte)(1) ;
      gxTv_Sdtimportacion_legajo_Migrlegmarcacct = "" ;
      SetDirty("Migrlegmarcacct");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegmarcacct_IsNull( )
   {
      return (gxTv_Sdtimportacion_legajo_Migrlegmarcacct_N==1) ;
   }

   public short getgxTv_Sdtimportacion_legajo_Migrarchsec( )
   {
      return gxTv_Sdtimportacion_legajo_Migrarchsec ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrarchsec( short value )
   {
      gxTv_Sdtimportacion_legajo_Migrarchsec_N = (byte)(0) ;
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrarchsec");
      gxTv_Sdtimportacion_legajo_Migrarchsec = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrarchsec_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrarchsec_N = (byte)(1) ;
      gxTv_Sdtimportacion_legajo_Migrarchsec = (short)(0) ;
      SetDirty("Migrarchsec");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrarchsec_IsNull( )
   {
      return (gxTv_Sdtimportacion_legajo_Migrarchsec_N==1) ;
   }

   public GXBCLevelCollection<web.Sdtimportacion_legajo_Familia> getgxTv_Sdtimportacion_legajo_Familia( )
   {
      if ( gxTv_Sdtimportacion_legajo_Familia == null )
      {
         gxTv_Sdtimportacion_legajo_Familia = new GXBCLevelCollection<web.Sdtimportacion_legajo_Familia>(web.Sdtimportacion_legajo_Familia.class, "importacion_legajo.Familia", "PayDay", remoteHandle);
      }
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      return gxTv_Sdtimportacion_legajo_Familia ;
   }

   public void setgxTv_Sdtimportacion_legajo_Familia( GXBCLevelCollection<web.Sdtimportacion_legajo_Familia> value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Familia");
      gxTv_Sdtimportacion_legajo_Familia = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Familia_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Familia = null ;
      SetDirty("Familia");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Familia_IsNull( )
   {
      if ( gxTv_Sdtimportacion_legajo_Familia == null )
      {
         return true ;
      }
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegactlabclas( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegactlabclas ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegactlabclas( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegactlabclas");
      gxTv_Sdtimportacion_legajo_Migrlegactlabclas = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegpueafip( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegpueafip ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegpueafip( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegpueafip");
      gxTv_Sdtimportacion_legajo_Migrlegpueafip = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtimportacion_legajo_Migrleghorsem( )
   {
      return gxTv_Sdtimportacion_legajo_Migrleghorsem ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrleghorsem( java.math.BigDecimal value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrleghorsem");
      gxTv_Sdtimportacion_legajo_Migrleghorsem = value ;
   }

   public String getgxTv_Sdtimportacion_legajo_Mode( )
   {
      return gxTv_Sdtimportacion_legajo_Mode ;
   }

   public void setgxTv_Sdtimportacion_legajo_Mode( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_Sdtimportacion_legajo_Mode = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Mode_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtimportacion_legajo_Initialized( )
   {
      return gxTv_Sdtimportacion_legajo_Initialized ;
   }

   public void setgxTv_Sdtimportacion_legajo_Initialized( short value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_Sdtimportacion_legajo_Initialized = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Initialized_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_Sdtimportacion_legajo_Clicod_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Clicod_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Clicod_Z( int value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_Sdtimportacion_legajo_Clicod_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Clicod_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtimportacion_legajo_Empcod_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Empcod_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Empcod_Z( short value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Empcod_Z");
      gxTv_Sdtimportacion_legajo_Empcod_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Empcod_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Empcod_Z = (short)(0) ;
      SetDirty("Empcod_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Empcod_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_Sdtimportacion_legajo_Migrlegnumero_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegnumero_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegnumero_Z( int value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegnumero_Z");
      gxTv_Sdtimportacion_legajo_Migrlegnumero_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegnumero_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegnumero_Z = 0 ;
      SetDirty("Migrlegnumero_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegnumero_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegapellido_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegapellido_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegapellido_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegapellido_Z");
      gxTv_Sdtimportacion_legajo_Migrlegapellido_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegapellido_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegapellido_Z = "" ;
      SetDirty("Migrlegapellido_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegapellido_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegnombre_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegnombre_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegnombre_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegnombre_Z");
      gxTv_Sdtimportacion_legajo_Migrlegnombre_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegnombre_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegnombre_Z = "" ;
      SetDirty("Migrlegnombre_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegnombre_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_Sdtimportacion_legajo_Migrlegfecnac_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegfecnac_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegfecnac_Z( java.util.Date value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegfecnac_Z");
      gxTv_Sdtimportacion_legajo_Migrlegfecnac_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegfecnac_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegfecnac_Z = GXutil.nullDate() ;
      SetDirty("Migrlegfecnac_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegfecnac_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegsexo_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegsexo_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegsexo_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegsexo_Z");
      gxTv_Sdtimportacion_legajo_Migrlegsexo_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegsexo_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegsexo_Z = "" ;
      SetDirty("Migrlegsexo_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegsexo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegestadocivil_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegestadocivil_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegestadocivil_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegestadocivil_Z");
      gxTv_Sdtimportacion_legajo_Migrlegestadocivil_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegestadocivil_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegestadocivil_Z = "" ;
      SetDirty("Migrlegestadocivil_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegestadocivil_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegcuil_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegcuil_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegcuil_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegcuil_Z");
      gxTv_Sdtimportacion_legajo_Migrlegcuil_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegcuil_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegcuil_Z = "" ;
      SetDirty("Migrlegcuil_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegcuil_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegdiscapacidad_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegdiscapacidad_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegdiscapacidad_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegdiscapacidad_Z");
      gxTv_Sdtimportacion_legajo_Migrlegdiscapacidad_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegdiscapacidad_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegdiscapacidad_Z = "" ;
      SetDirty("Migrlegdiscapacidad_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegdiscapacidad_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegdomici_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegdomici_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegdomici_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegdomici_Z");
      gxTv_Sdtimportacion_legajo_Migrlegdomici_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegdomici_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegdomici_Z = "" ;
      SetDirty("Migrlegdomici_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegdomici_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegemail_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegemail_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegemail_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegemail_Z");
      gxTv_Sdtimportacion_legajo_Migrlegemail_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegemail_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegemail_Z = "" ;
      SetDirty("Migrlegemail_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegemail_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegcodpos_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegcodpos_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegcodpos_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegcodpos_Z");
      gxTv_Sdtimportacion_legajo_Migrlegcodpos_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegcodpos_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegcodpos_Z = "" ;
      SetDirty("Migrlegcodpos_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegcodpos_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegtelefono_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegtelefono_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegtelefono_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegtelefono_Z");
      gxTv_Sdtimportacion_legajo_Migrlegtelefono_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegtelefono_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegtelefono_Z = "" ;
      SetDirty("Migrlegtelefono_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegtelefono_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_Sdtimportacion_legajo_Migrlegfecingreso_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegfecingreso_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegfecingreso_Z( java.util.Date value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegfecingreso_Z");
      gxTv_Sdtimportacion_legajo_Migrlegfecingreso_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegfecingreso_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegfecingreso_Z = GXutil.nullDate() ;
      SetDirty("Migrlegfecingreso_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegfecingreso_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegcategoria_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegcategoria_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegcategoria_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegcategoria_Z");
      gxTv_Sdtimportacion_legajo_Migrlegcategoria_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegcategoria_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegcategoria_Z = "" ;
      SetDirty("Migrlegcategoria_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegcategoria_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegarea_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegarea_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegarea_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegarea_Z");
      gxTv_Sdtimportacion_legajo_Migrlegarea_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegarea_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegarea_Z = "" ;
      SetDirty("Migrlegarea_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegarea_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrleglugardepago_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrleglugardepago_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrleglugardepago_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrleglugardepago_Z");
      gxTv_Sdtimportacion_legajo_Migrleglugardepago_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrleglugardepago_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrleglugardepago_Z = "" ;
      SetDirty("Migrleglugardepago_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrleglugardepago_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegmodtra_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegmodtra_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegmodtra_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegmodtra_Z");
      gxTv_Sdtimportacion_legajo_Migrlegmodtra_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegmodtra_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegmodtra_Z = "" ;
      SetDirty("Migrlegmodtra_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegmodtra_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegtipotarifa_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegtipotarifa_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegtipotarifa_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegtipotarifa_Z");
      gxTv_Sdtimportacion_legajo_Migrlegtipotarifa_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegtipotarifa_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegtipotarifa_Z = "" ;
      SetDirty("Migrlegtipotarifa_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegtipotarifa_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegclase_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegclase_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegclase_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegclase_Z");
      gxTv_Sdtimportacion_legajo_Migrlegclase_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegclase_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegclase_Z = "" ;
      SetDirty("Migrlegclase_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegclase_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_Sdtimportacion_legajo_Migrlegbasico_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegbasico_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegbasico_Z( java.math.BigDecimal value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegbasico_Z");
      gxTv_Sdtimportacion_legajo_Migrlegbasico_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegbasico_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegbasico_Z = DecimalUtil.ZERO ;
      SetDirty("Migrlegbasico_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegbasico_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegformapago_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegformapago_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegformapago_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegformapago_Z");
      gxTv_Sdtimportacion_legajo_Migrlegformapago_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegformapago_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegformapago_Z = "" ;
      SetDirty("Migrlegformapago_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegformapago_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegclasedef_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegclasedef_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegclasedef_Z( boolean value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegclasedef_Z");
      gxTv_Sdtimportacion_legajo_Migrlegclasedef_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegclasedef_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegclasedef_Z = false ;
      SetDirty("Migrlegclasedef_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegclasedef_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegbanco_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegbanco_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegbanco_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegbanco_Z");
      gxTv_Sdtimportacion_legajo_Migrlegbanco_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegbanco_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegbanco_Z = "" ;
      SetDirty("Migrlegbanco_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegbanco_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegbansuc_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegbansuc_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegbansuc_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegbansuc_Z");
      gxTv_Sdtimportacion_legajo_Migrlegbansuc_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegbansuc_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegbansuc_Z = "" ;
      SetDirty("Migrlegbansuc_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegbansuc_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegbantipcuen_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegbantipcuen_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegbantipcuen_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegbantipcuen_Z");
      gxTv_Sdtimportacion_legajo_Migrlegbantipcuen_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegbantipcuen_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegbantipcuen_Z = "" ;
      SetDirty("Migrlegbantipcuen_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegbantipcuen_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegsindicato_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegsindicato_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegsindicato_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegsindicato_Z");
      gxTv_Sdtimportacion_legajo_Migrlegsindicato_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegsindicato_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegsindicato_Z = "" ;
      SetDirty("Migrlegsindicato_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegsindicato_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegobrasocial_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegobrasocial_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegobrasocial_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegobrasocial_Z");
      gxTv_Sdtimportacion_legajo_Migrlegobrasocial_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegobrasocial_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegobrasocial_Z = "" ;
      SetDirty("Migrlegobrasocial_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegobrasocial_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegosafip_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegosafip_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegosafip_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegosafip_Z");
      gxTv_Sdtimportacion_legajo_Migrlegosafip_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegosafip_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegosafip_Z = "" ;
      SetDirty("Migrlegosafip_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegosafip_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegplanmedico_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegplanmedico_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegplanmedico_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegplanmedico_Z");
      gxTv_Sdtimportacion_legajo_Migrlegplanmedico_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegplanmedico_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegplanmedico_Z = "" ;
      SetDirty("Migrlegplanmedico_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegplanmedico_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegactividad_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegactividad_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegactividad_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegactividad_Z");
      gxTv_Sdtimportacion_legajo_Migrlegactividad_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegactividad_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegactividad_Z = "" ;
      SetDirty("Migrlegactividad_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegactividad_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegmodalidad_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegmodalidad_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegmodalidad_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegmodalidad_Z");
      gxTv_Sdtimportacion_legajo_Migrlegmodalidad_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegmodalidad_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegmodalidad_Z = "" ;
      SetDirty("Migrlegmodalidad_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegmodalidad_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_Sdtimportacion_legajo_Migrlegfecultmod_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegfecultmod_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegfecultmod_Z( java.util.Date value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegfecultmod_Z");
      gxTv_Sdtimportacion_legajo_Migrlegfecultmod_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegfecultmod_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegfecultmod_Z = GXutil.nullDate() ;
      SetDirty("Migrlegfecultmod_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegfecultmod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegcuentabanc_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegcuentabanc_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegcuentabanc_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegcuentabanc_Z");
      gxTv_Sdtimportacion_legajo_Migrlegcuentabanc_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegcuentabanc_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegcuentabanc_Z = "" ;
      SetDirty("Migrlegcuentabanc_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegcuentabanc_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegzona_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegzona_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegzona_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegzona_Z");
      gxTv_Sdtimportacion_legajo_Migrlegzona_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegzona_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegzona_Z = "" ;
      SetDirty("Migrlegzona_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegzona_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegcbu_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegcbu_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegcbu_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegcbu_Z");
      gxTv_Sdtimportacion_legajo_Migrlegcbu_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegcbu_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegcbu_Z = "" ;
      SetDirty("Migrlegcbu_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegcbu_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegscvo_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegscvo_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegscvo_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegscvo_Z");
      gxTv_Sdtimportacion_legajo_Migrlegscvo_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegscvo_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegscvo_Z = "" ;
      SetDirty("Migrlegscvo_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegscvo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegsituacionrevista_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegsituacionrevista_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegsituacionrevista_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegsituacionrevista_Z");
      gxTv_Sdtimportacion_legajo_Migrlegsituacionrevista_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegsituacionrevista_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegsituacionrevista_Z = "" ;
      SetDirty("Migrlegsituacionrevista_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegsituacionrevista_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegcondicion_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegcondicion_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegcondicion_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegcondicion_Z");
      gxTv_Sdtimportacion_legajo_Migrlegcondicion_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegcondicion_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegcondicion_Z = "" ;
      SetDirty("Migrlegcondicion_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegcondicion_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegsiniestrado_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegsiniestrado_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegsiniestrado_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegsiniestrado_Z");
      gxTv_Sdtimportacion_legajo_Migrlegsiniestrado_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegsiniestrado_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegsiniestrado_Z = "" ;
      SetDirty("Migrlegsiniestrado_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegsiniestrado_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegid_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegid_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegid_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegid_Z");
      gxTv_Sdtimportacion_legajo_Migrlegid_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegid_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegid_Z = "" ;
      SetDirty("Migrlegid_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegconvenio_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegconvenio_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegconvenio_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegconvenio_Z");
      gxTv_Sdtimportacion_legajo_Migrlegconvenio_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegconvenio_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegconvenio_Z = "" ;
      SetDirty("Migrlegconvenio_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegconvenio_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrtieneconyuge_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrtieneconyuge_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrtieneconyuge_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrtieneconyuge_Z");
      gxTv_Sdtimportacion_legajo_Migrtieneconyuge_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrtieneconyuge_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrtieneconyuge_Z = "" ;
      SetDirty("Migrtieneconyuge_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrtieneconyuge_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtimportacion_legajo_Migrcantidadhijos_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrcantidadhijos_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrcantidadhijos_Z( short value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrcantidadhijos_Z");
      gxTv_Sdtimportacion_legajo_Migrcantidadhijos_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrcantidadhijos_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrcantidadhijos_Z = (short)(0) ;
      SetDirty("Migrcantidadhijos_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrcantidadhijos_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrencontroososigla_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrencontroososigla_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrencontroososigla_Z( boolean value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrencontroososigla_Z");
      gxTv_Sdtimportacion_legajo_Migrencontroososigla_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrencontroososigla_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrencontroososigla_Z = false ;
      SetDirty("Migrencontroososigla_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrencontroososigla_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrtradiurno_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrtradiurno_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrtradiurno_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrtradiurno_Z");
      gxTv_Sdtimportacion_legajo_Migrtradiurno_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrtradiurno_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrtradiurno_Z = "" ;
      SetDirty("Migrtradiurno_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrtradiurno_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrtranoct_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrtranoct_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrtranoct_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrtranoct_Z");
      gxTv_Sdtimportacion_legajo_Migrtranoct_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrtranoct_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrtranoct_Z = "" ;
      SetDirty("Migrtranoct_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrtranoct_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrtrains_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrtrains_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrtrains_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrtrains_Z");
      gxTv_Sdtimportacion_legajo_Migrtrains_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrtrains_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrtrains_Z = "" ;
      SetDirty("Migrtrains_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrtrains_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrencontroosoafip_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrencontroosoafip_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrencontroosoafip_Z( boolean value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrencontroosoafip_Z");
      gxTv_Sdtimportacion_legajo_Migrencontroosoafip_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrencontroosoafip_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrencontroosoafip_Z = false ;
      SetDirty("Migrencontroosoafip_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrencontroosoafip_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_Sdtimportacion_legajo_Migrperiodo_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrperiodo_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrperiodo_Z( java.util.Date value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrperiodo_Z");
      gxTv_Sdtimportacion_legajo_Migrperiodo_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrperiodo_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrperiodo_Z = GXutil.nullDate() ;
      SetDirty("Migrperiodo_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrperiodo_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegmodalidaddef_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegmodalidaddef_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegmodalidaddef_Z( boolean value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegmodalidaddef_Z");
      gxTv_Sdtimportacion_legajo_Migrlegmodalidaddef_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegmodalidaddef_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegmodalidaddef_Z = false ;
      SetDirty("Migrlegmodalidaddef_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegmodalidaddef_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegzonadef_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegzonadef_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegzonadef_Z( boolean value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegzonadef_Z");
      gxTv_Sdtimportacion_legajo_Migrlegzonadef_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegzonadef_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegzonadef_Z = false ;
      SetDirty("Migrlegzonadef_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegzonadef_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegsituaciondef_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegsituaciondef_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegsituaciondef_Z( boolean value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegsituaciondef_Z");
      gxTv_Sdtimportacion_legajo_Migrlegsituaciondef_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegsituaciondef_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegsituaciondef_Z = false ;
      SetDirty("Migrlegsituaciondef_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegsituaciondef_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegestadocivildef_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegestadocivildef_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegestadocivildef_Z( boolean value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegestadocivildef_Z");
      gxTv_Sdtimportacion_legajo_Migrlegestadocivildef_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegestadocivildef_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegestadocivildef_Z = false ;
      SetDirty("Migrlegestadocivildef_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegestadocivildef_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegformapagodef_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegformapagodef_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegformapagodef_Z( boolean value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegformapagodef_Z");
      gxTv_Sdtimportacion_legajo_Migrlegformapagodef_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegformapagodef_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegformapagodef_Z = false ;
      SetDirty("Migrlegformapagodef_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegformapagodef_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegtipocuentadef_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegtipocuentadef_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegtipocuentadef_Z( boolean value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegtipocuentadef_Z");
      gxTv_Sdtimportacion_legajo_Migrlegtipocuentadef_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegtipocuentadef_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegtipocuentadef_Z = false ;
      SetDirty("Migrlegtipocuentadef_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegtipocuentadef_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegactividaddef_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegactividaddef_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegactividaddef_Z( boolean value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegactividaddef_Z");
      gxTv_Sdtimportacion_legajo_Migrlegactividaddef_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegactividaddef_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegactividaddef_Z = false ;
      SetDirty("Migrlegactividaddef_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegactividaddef_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegcondiciondef_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegcondiciondef_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegcondiciondef_Z( boolean value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegcondiciondef_Z");
      gxTv_Sdtimportacion_legajo_Migrlegcondiciondef_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegcondiciondef_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegcondiciondef_Z = false ;
      SetDirty("Migrlegcondiciondef_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegcondiciondef_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegsiniestradodef_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegsiniestradodef_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegsiniestradodef_Z( boolean value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegsiniestradodef_Z");
      gxTv_Sdtimportacion_legajo_Migrlegsiniestradodef_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegsiniestradodef_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegsiniestradodef_Z = false ;
      SetDirty("Migrlegsiniestradodef_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegsiniestradodef_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrvalcadasave_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrvalcadasave_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrvalcadasave_Z( boolean value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrvalcadasave_Z");
      gxTv_Sdtimportacion_legajo_Migrvalcadasave_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrvalcadasave_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrvalcadasave_Z = false ;
      SetDirty("Migrvalcadasave_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrvalcadasave_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_Sdtimportacion_legajo_Migrlegfecegreso_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegfecegreso_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegfecegreso_Z( java.util.Date value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegfecegreso_Z");
      gxTv_Sdtimportacion_legajo_Migrlegfecegreso_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegfecegreso_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegfecegreso_Z = GXutil.nullDate() ;
      SetDirty("Migrlegfecegreso_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegfecegreso_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrpuesto_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrpuesto_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrpuesto_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrpuesto_Z");
      gxTv_Sdtimportacion_legajo_Migrpuesto_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrpuesto_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrpuesto_Z = "" ;
      SetDirty("Migrpuesto_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrpuesto_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegmarcacct_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegmarcacct_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegmarcacct_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegmarcacct_Z");
      gxTv_Sdtimportacion_legajo_Migrlegmarcacct_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegmarcacct_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegmarcacct_Z = "" ;
      SetDirty("Migrlegmarcacct_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegmarcacct_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtimportacion_legajo_Migrarchsec_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrarchsec_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrarchsec_Z( short value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrarchsec_Z");
      gxTv_Sdtimportacion_legajo_Migrarchsec_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrarchsec_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrarchsec_Z = (short)(0) ;
      SetDirty("Migrarchsec_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrarchsec_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegactlabclas_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegactlabclas_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegactlabclas_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegactlabclas_Z");
      gxTv_Sdtimportacion_legajo_Migrlegactlabclas_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegactlabclas_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegactlabclas_Z = "" ;
      SetDirty("Migrlegactlabclas_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegactlabclas_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajo_Migrlegpueafip_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegpueafip_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegpueafip_Z( String value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegpueafip_Z");
      gxTv_Sdtimportacion_legajo_Migrlegpueafip_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegpueafip_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegpueafip_Z = "" ;
      SetDirty("Migrlegpueafip_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegpueafip_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_Sdtimportacion_legajo_Migrleghorsem_Z( )
   {
      return gxTv_Sdtimportacion_legajo_Migrleghorsem_Z ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrleghorsem_Z( java.math.BigDecimal value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrleghorsem_Z");
      gxTv_Sdtimportacion_legajo_Migrleghorsem_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrleghorsem_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrleghorsem_Z = DecimalUtil.ZERO ;
      SetDirty("Migrleghorsem_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrleghorsem_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_Sdtimportacion_legajo_Migrlegmarcacct_N( )
   {
      return gxTv_Sdtimportacion_legajo_Migrlegmarcacct_N ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegmarcacct_N( byte value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrlegmarcacct_N");
      gxTv_Sdtimportacion_legajo_Migrlegmarcacct_N = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrlegmarcacct_N_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrlegmarcacct_N = (byte)(0) ;
      SetDirty("Migrlegmarcacct_N");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrlegmarcacct_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_Sdtimportacion_legajo_Migrarchsec_N( )
   {
      return gxTv_Sdtimportacion_legajo_Migrarchsec_N ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrarchsec_N( byte value )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(0) ;
      SetDirty("Migrarchsec_N");
      gxTv_Sdtimportacion_legajo_Migrarchsec_N = value ;
   }

   public void setgxTv_Sdtimportacion_legajo_Migrarchsec_N_SetNull( )
   {
      gxTv_Sdtimportacion_legajo_Migrarchsec_N = (byte)(0) ;
      SetDirty("Migrarchsec_N");
   }

   public boolean getgxTv_Sdtimportacion_legajo_Migrarchsec_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.importacion_legajo_bc obj;
      obj = new web.importacion_legajo_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_Sdtimportacion_legajo_N = (byte)(1) ;
      gxTv_Sdtimportacion_legajo_Migrlegapellido = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegnombre = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegfecnac = GXutil.nullDate() ;
      gxTv_Sdtimportacion_legajo_Migrlegsexo = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegestadocivil = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegcuil = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegdiscapacidad = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegdomici = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegemail = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegcodpos = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegtelefono = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegfecingreso = GXutil.nullDate() ;
      gxTv_Sdtimportacion_legajo_Migrlegcategoria = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegarea = "" ;
      gxTv_Sdtimportacion_legajo_Migrleglugardepago = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegmodtra = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegtipotarifa = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegclase = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegbasico = DecimalUtil.ZERO ;
      gxTv_Sdtimportacion_legajo_Migrlegformapago = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegbanco = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegbansuc = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegbantipcuen = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegsindicato = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegobrasocial = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegosafip = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegplanmedico = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegactividad = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegmodalidad = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegfecultmod = GXutil.nullDate() ;
      gxTv_Sdtimportacion_legajo_Migrlegcuentabanc = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegzona = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegcbu = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegscvo = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegsituacionrevista = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegcondicion = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegsiniestrado = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegid = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegconvenio = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegobs = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegerrores = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegwarnings = "" ;
      gxTv_Sdtimportacion_legajo_Migrtieneconyuge = "" ;
      gxTv_Sdtimportacion_legajo_Migrtradiurno = "" ;
      gxTv_Sdtimportacion_legajo_Migrtranoct = "" ;
      gxTv_Sdtimportacion_legajo_Migrtrains = "" ;
      gxTv_Sdtimportacion_legajo_Migrsueldos = "" ;
      gxTv_Sdtimportacion_legajo_Migrperiodo = GXutil.nullDate() ;
      gxTv_Sdtimportacion_legajo_Migrlegfecegreso = GXutil.nullDate() ;
      gxTv_Sdtimportacion_legajo_Migrotrosdatos = "" ;
      gxTv_Sdtimportacion_legajo_Migrpuesto = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegmarcacct = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegactlabclas = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegpueafip = "" ;
      gxTv_Sdtimportacion_legajo_Migrleghorsem = DecimalUtil.ZERO ;
      gxTv_Sdtimportacion_legajo_Mode = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegapellido_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegnombre_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegfecnac_Z = GXutil.nullDate() ;
      gxTv_Sdtimportacion_legajo_Migrlegsexo_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegestadocivil_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegcuil_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegdiscapacidad_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegdomici_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegemail_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegcodpos_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegtelefono_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegfecingreso_Z = GXutil.nullDate() ;
      gxTv_Sdtimportacion_legajo_Migrlegcategoria_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegarea_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrleglugardepago_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegmodtra_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegtipotarifa_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegclase_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegbasico_Z = DecimalUtil.ZERO ;
      gxTv_Sdtimportacion_legajo_Migrlegformapago_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegbanco_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegbansuc_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegbantipcuen_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegsindicato_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegobrasocial_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegosafip_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegplanmedico_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegactividad_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegmodalidad_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegfecultmod_Z = GXutil.nullDate() ;
      gxTv_Sdtimportacion_legajo_Migrlegcuentabanc_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegzona_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegcbu_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegscvo_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegsituacionrevista_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegcondicion_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegsiniestrado_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegid_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegconvenio_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrtieneconyuge_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrtradiurno_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrtranoct_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrtrains_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrperiodo_Z = GXutil.nullDate() ;
      gxTv_Sdtimportacion_legajo_Migrlegfecegreso_Z = GXutil.nullDate() ;
      gxTv_Sdtimportacion_legajo_Migrpuesto_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegmarcacct_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegactlabclas_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrlegpueafip_Z = "" ;
      gxTv_Sdtimportacion_legajo_Migrleghorsem_Z = DecimalUtil.ZERO ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtimportacion_legajo_N ;
   }

   public web.Sdtimportacion_legajo Clone( )
   {
      web.Sdtimportacion_legajo sdt;
      web.importacion_legajo_bc obj;
      sdt = (web.Sdtimportacion_legajo)(clone()) ;
      obj = (web.importacion_legajo_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtimportacion_legajo struct )
   {
      setgxTv_Sdtimportacion_legajo_Clicod(struct.getClicod());
      setgxTv_Sdtimportacion_legajo_Empcod(struct.getEmpcod());
      setgxTv_Sdtimportacion_legajo_Migrlegnumero(struct.getMigrlegnumero());
      setgxTv_Sdtimportacion_legajo_Migrlegapellido(struct.getMigrlegapellido());
      setgxTv_Sdtimportacion_legajo_Migrlegnombre(struct.getMigrlegnombre());
      setgxTv_Sdtimportacion_legajo_Migrlegfecnac(struct.getMigrlegfecnac());
      setgxTv_Sdtimportacion_legajo_Migrlegsexo(struct.getMigrlegsexo());
      setgxTv_Sdtimportacion_legajo_Migrlegestadocivil(struct.getMigrlegestadocivil());
      setgxTv_Sdtimportacion_legajo_Migrlegcuil(struct.getMigrlegcuil());
      setgxTv_Sdtimportacion_legajo_Migrlegdiscapacidad(struct.getMigrlegdiscapacidad());
      setgxTv_Sdtimportacion_legajo_Migrlegdomici(struct.getMigrlegdomici());
      setgxTv_Sdtimportacion_legajo_Migrlegemail(struct.getMigrlegemail());
      setgxTv_Sdtimportacion_legajo_Migrlegcodpos(struct.getMigrlegcodpos());
      setgxTv_Sdtimportacion_legajo_Migrlegtelefono(struct.getMigrlegtelefono());
      setgxTv_Sdtimportacion_legajo_Migrlegfecingreso(struct.getMigrlegfecingreso());
      setgxTv_Sdtimportacion_legajo_Migrlegcategoria(struct.getMigrlegcategoria());
      setgxTv_Sdtimportacion_legajo_Migrlegarea(struct.getMigrlegarea());
      setgxTv_Sdtimportacion_legajo_Migrleglugardepago(struct.getMigrleglugardepago());
      setgxTv_Sdtimportacion_legajo_Migrlegmodtra(struct.getMigrlegmodtra());
      setgxTv_Sdtimportacion_legajo_Migrlegtipotarifa(struct.getMigrlegtipotarifa());
      setgxTv_Sdtimportacion_legajo_Migrlegclase(struct.getMigrlegclase());
      setgxTv_Sdtimportacion_legajo_Migrlegbasico(struct.getMigrlegbasico());
      setgxTv_Sdtimportacion_legajo_Migrlegformapago(struct.getMigrlegformapago());
      setgxTv_Sdtimportacion_legajo_Migrlegclasedef(struct.getMigrlegclasedef());
      setgxTv_Sdtimportacion_legajo_Migrlegbanco(struct.getMigrlegbanco());
      setgxTv_Sdtimportacion_legajo_Migrlegbansuc(struct.getMigrlegbansuc());
      setgxTv_Sdtimportacion_legajo_Migrlegbantipcuen(struct.getMigrlegbantipcuen());
      setgxTv_Sdtimportacion_legajo_Migrlegsindicato(struct.getMigrlegsindicato());
      setgxTv_Sdtimportacion_legajo_Migrlegobrasocial(struct.getMigrlegobrasocial());
      setgxTv_Sdtimportacion_legajo_Migrlegosafip(struct.getMigrlegosafip());
      setgxTv_Sdtimportacion_legajo_Migrlegplanmedico(struct.getMigrlegplanmedico());
      setgxTv_Sdtimportacion_legajo_Migrlegactividad(struct.getMigrlegactividad());
      setgxTv_Sdtimportacion_legajo_Migrlegmodalidad(struct.getMigrlegmodalidad());
      setgxTv_Sdtimportacion_legajo_Migrlegfecultmod(struct.getMigrlegfecultmod());
      setgxTv_Sdtimportacion_legajo_Migrlegcuentabanc(struct.getMigrlegcuentabanc());
      setgxTv_Sdtimportacion_legajo_Migrlegzona(struct.getMigrlegzona());
      setgxTv_Sdtimportacion_legajo_Migrlegcbu(struct.getMigrlegcbu());
      setgxTv_Sdtimportacion_legajo_Migrlegscvo(struct.getMigrlegscvo());
      setgxTv_Sdtimportacion_legajo_Migrlegsituacionrevista(struct.getMigrlegsituacionrevista());
      setgxTv_Sdtimportacion_legajo_Migrlegcondicion(struct.getMigrlegcondicion());
      setgxTv_Sdtimportacion_legajo_Migrlegsiniestrado(struct.getMigrlegsiniestrado());
      setgxTv_Sdtimportacion_legajo_Migrlegid(struct.getMigrlegid());
      setgxTv_Sdtimportacion_legajo_Migrlegconvenio(struct.getMigrlegconvenio());
      setgxTv_Sdtimportacion_legajo_Migrlegobs(struct.getMigrlegobs());
      setgxTv_Sdtimportacion_legajo_Migrlegerrores(struct.getMigrlegerrores());
      setgxTv_Sdtimportacion_legajo_Migrlegwarnings(struct.getMigrlegwarnings());
      setgxTv_Sdtimportacion_legajo_Migrtieneconyuge(struct.getMigrtieneconyuge());
      setgxTv_Sdtimportacion_legajo_Migrcantidadhijos(struct.getMigrcantidadhijos());
      setgxTv_Sdtimportacion_legajo_Migrencontroososigla(struct.getMigrencontroososigla());
      setgxTv_Sdtimportacion_legajo_Migrtradiurno(struct.getMigrtradiurno());
      setgxTv_Sdtimportacion_legajo_Migrtranoct(struct.getMigrtranoct());
      setgxTv_Sdtimportacion_legajo_Migrtrains(struct.getMigrtrains());
      setgxTv_Sdtimportacion_legajo_Migrencontroosoafip(struct.getMigrencontroosoafip());
      setgxTv_Sdtimportacion_legajo_Migrsueldos(struct.getMigrsueldos());
      setgxTv_Sdtimportacion_legajo_Migrperiodo(struct.getMigrperiodo());
      setgxTv_Sdtimportacion_legajo_Migrlegmodalidaddef(struct.getMigrlegmodalidaddef());
      setgxTv_Sdtimportacion_legajo_Migrlegzonadef(struct.getMigrlegzonadef());
      setgxTv_Sdtimportacion_legajo_Migrlegsituaciondef(struct.getMigrlegsituaciondef());
      setgxTv_Sdtimportacion_legajo_Migrlegestadocivildef(struct.getMigrlegestadocivildef());
      setgxTv_Sdtimportacion_legajo_Migrlegformapagodef(struct.getMigrlegformapagodef());
      setgxTv_Sdtimportacion_legajo_Migrlegtipocuentadef(struct.getMigrlegtipocuentadef());
      setgxTv_Sdtimportacion_legajo_Migrlegactividaddef(struct.getMigrlegactividaddef());
      setgxTv_Sdtimportacion_legajo_Migrlegcondiciondef(struct.getMigrlegcondiciondef());
      setgxTv_Sdtimportacion_legajo_Migrlegsiniestradodef(struct.getMigrlegsiniestradodef());
      setgxTv_Sdtimportacion_legajo_Migrvalcadasave(struct.getMigrvalcadasave());
      setgxTv_Sdtimportacion_legajo_Migrlegfecegreso(struct.getMigrlegfecegreso());
      setgxTv_Sdtimportacion_legajo_Migrotrosdatos(struct.getMigrotrosdatos());
      setgxTv_Sdtimportacion_legajo_Migrpuesto(struct.getMigrpuesto());
      setgxTv_Sdtimportacion_legajo_Migrlegmarcacct(struct.getMigrlegmarcacct());
      setgxTv_Sdtimportacion_legajo_Migrarchsec(struct.getMigrarchsec());
      GXBCLevelCollection<web.Sdtimportacion_legajo_Familia> gxTv_Sdtimportacion_legajo_Familia_aux = new GXBCLevelCollection<web.Sdtimportacion_legajo_Familia>(web.Sdtimportacion_legajo_Familia.class, "importacion_legajo.Familia", "PayDay", remoteHandle);
      Vector<web.StructSdtimportacion_legajo_Familia> gxTv_Sdtimportacion_legajo_Familia_aux1 = struct.getFamilia();
      if (gxTv_Sdtimportacion_legajo_Familia_aux1 != null)
      {
         for (int i = 0; i < gxTv_Sdtimportacion_legajo_Familia_aux1.size(); i++)
         {
            gxTv_Sdtimportacion_legajo_Familia_aux.add(new web.Sdtimportacion_legajo_Familia(remoteHandle, gxTv_Sdtimportacion_legajo_Familia_aux1.elementAt(i)));
         }
      }
      setgxTv_Sdtimportacion_legajo_Familia(gxTv_Sdtimportacion_legajo_Familia_aux);
      setgxTv_Sdtimportacion_legajo_Migrlegactlabclas(struct.getMigrlegactlabclas());
      setgxTv_Sdtimportacion_legajo_Migrlegpueafip(struct.getMigrlegpueafip());
      setgxTv_Sdtimportacion_legajo_Migrleghorsem(struct.getMigrleghorsem());
      setgxTv_Sdtimportacion_legajo_Mode(struct.getMode());
      setgxTv_Sdtimportacion_legajo_Initialized(struct.getInitialized());
      setgxTv_Sdtimportacion_legajo_Clicod_Z(struct.getClicod_Z());
      setgxTv_Sdtimportacion_legajo_Empcod_Z(struct.getEmpcod_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegnumero_Z(struct.getMigrlegnumero_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegapellido_Z(struct.getMigrlegapellido_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegnombre_Z(struct.getMigrlegnombre_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegfecnac_Z(struct.getMigrlegfecnac_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegsexo_Z(struct.getMigrlegsexo_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegestadocivil_Z(struct.getMigrlegestadocivil_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegcuil_Z(struct.getMigrlegcuil_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegdiscapacidad_Z(struct.getMigrlegdiscapacidad_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegdomici_Z(struct.getMigrlegdomici_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegemail_Z(struct.getMigrlegemail_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegcodpos_Z(struct.getMigrlegcodpos_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegtelefono_Z(struct.getMigrlegtelefono_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegfecingreso_Z(struct.getMigrlegfecingreso_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegcategoria_Z(struct.getMigrlegcategoria_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegarea_Z(struct.getMigrlegarea_Z());
      setgxTv_Sdtimportacion_legajo_Migrleglugardepago_Z(struct.getMigrleglugardepago_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegmodtra_Z(struct.getMigrlegmodtra_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegtipotarifa_Z(struct.getMigrlegtipotarifa_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegclase_Z(struct.getMigrlegclase_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegbasico_Z(struct.getMigrlegbasico_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegformapago_Z(struct.getMigrlegformapago_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegclasedef_Z(struct.getMigrlegclasedef_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegbanco_Z(struct.getMigrlegbanco_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegbansuc_Z(struct.getMigrlegbansuc_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegbantipcuen_Z(struct.getMigrlegbantipcuen_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegsindicato_Z(struct.getMigrlegsindicato_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegobrasocial_Z(struct.getMigrlegobrasocial_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegosafip_Z(struct.getMigrlegosafip_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegplanmedico_Z(struct.getMigrlegplanmedico_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegactividad_Z(struct.getMigrlegactividad_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegmodalidad_Z(struct.getMigrlegmodalidad_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegfecultmod_Z(struct.getMigrlegfecultmod_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegcuentabanc_Z(struct.getMigrlegcuentabanc_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegzona_Z(struct.getMigrlegzona_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegcbu_Z(struct.getMigrlegcbu_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegscvo_Z(struct.getMigrlegscvo_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegsituacionrevista_Z(struct.getMigrlegsituacionrevista_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegcondicion_Z(struct.getMigrlegcondicion_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegsiniestrado_Z(struct.getMigrlegsiniestrado_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegid_Z(struct.getMigrlegid_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegconvenio_Z(struct.getMigrlegconvenio_Z());
      setgxTv_Sdtimportacion_legajo_Migrtieneconyuge_Z(struct.getMigrtieneconyuge_Z());
      setgxTv_Sdtimportacion_legajo_Migrcantidadhijos_Z(struct.getMigrcantidadhijos_Z());
      setgxTv_Sdtimportacion_legajo_Migrencontroososigla_Z(struct.getMigrencontroososigla_Z());
      setgxTv_Sdtimportacion_legajo_Migrtradiurno_Z(struct.getMigrtradiurno_Z());
      setgxTv_Sdtimportacion_legajo_Migrtranoct_Z(struct.getMigrtranoct_Z());
      setgxTv_Sdtimportacion_legajo_Migrtrains_Z(struct.getMigrtrains_Z());
      setgxTv_Sdtimportacion_legajo_Migrencontroosoafip_Z(struct.getMigrencontroosoafip_Z());
      setgxTv_Sdtimportacion_legajo_Migrperiodo_Z(struct.getMigrperiodo_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegmodalidaddef_Z(struct.getMigrlegmodalidaddef_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegzonadef_Z(struct.getMigrlegzonadef_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegsituaciondef_Z(struct.getMigrlegsituaciondef_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegestadocivildef_Z(struct.getMigrlegestadocivildef_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegformapagodef_Z(struct.getMigrlegformapagodef_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegtipocuentadef_Z(struct.getMigrlegtipocuentadef_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegactividaddef_Z(struct.getMigrlegactividaddef_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegcondiciondef_Z(struct.getMigrlegcondiciondef_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegsiniestradodef_Z(struct.getMigrlegsiniestradodef_Z());
      setgxTv_Sdtimportacion_legajo_Migrvalcadasave_Z(struct.getMigrvalcadasave_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegfecegreso_Z(struct.getMigrlegfecegreso_Z());
      setgxTv_Sdtimportacion_legajo_Migrpuesto_Z(struct.getMigrpuesto_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegmarcacct_Z(struct.getMigrlegmarcacct_Z());
      setgxTv_Sdtimportacion_legajo_Migrarchsec_Z(struct.getMigrarchsec_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegactlabclas_Z(struct.getMigrlegactlabclas_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegpueafip_Z(struct.getMigrlegpueafip_Z());
      setgxTv_Sdtimportacion_legajo_Migrleghorsem_Z(struct.getMigrleghorsem_Z());
      setgxTv_Sdtimportacion_legajo_Migrlegmarcacct_N(struct.getMigrlegmarcacct_N());
      setgxTv_Sdtimportacion_legajo_Migrarchsec_N(struct.getMigrarchsec_N());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtimportacion_legajo getStruct( )
   {
      web.StructSdtimportacion_legajo struct = new web.StructSdtimportacion_legajo ();
      struct.setClicod(getgxTv_Sdtimportacion_legajo_Clicod());
      struct.setEmpcod(getgxTv_Sdtimportacion_legajo_Empcod());
      struct.setMigrlegnumero(getgxTv_Sdtimportacion_legajo_Migrlegnumero());
      struct.setMigrlegapellido(getgxTv_Sdtimportacion_legajo_Migrlegapellido());
      struct.setMigrlegnombre(getgxTv_Sdtimportacion_legajo_Migrlegnombre());
      struct.setMigrlegfecnac(getgxTv_Sdtimportacion_legajo_Migrlegfecnac());
      struct.setMigrlegsexo(getgxTv_Sdtimportacion_legajo_Migrlegsexo());
      struct.setMigrlegestadocivil(getgxTv_Sdtimportacion_legajo_Migrlegestadocivil());
      struct.setMigrlegcuil(getgxTv_Sdtimportacion_legajo_Migrlegcuil());
      struct.setMigrlegdiscapacidad(getgxTv_Sdtimportacion_legajo_Migrlegdiscapacidad());
      struct.setMigrlegdomici(getgxTv_Sdtimportacion_legajo_Migrlegdomici());
      struct.setMigrlegemail(getgxTv_Sdtimportacion_legajo_Migrlegemail());
      struct.setMigrlegcodpos(getgxTv_Sdtimportacion_legajo_Migrlegcodpos());
      struct.setMigrlegtelefono(getgxTv_Sdtimportacion_legajo_Migrlegtelefono());
      struct.setMigrlegfecingreso(getgxTv_Sdtimportacion_legajo_Migrlegfecingreso());
      struct.setMigrlegcategoria(getgxTv_Sdtimportacion_legajo_Migrlegcategoria());
      struct.setMigrlegarea(getgxTv_Sdtimportacion_legajo_Migrlegarea());
      struct.setMigrleglugardepago(getgxTv_Sdtimportacion_legajo_Migrleglugardepago());
      struct.setMigrlegmodtra(getgxTv_Sdtimportacion_legajo_Migrlegmodtra());
      struct.setMigrlegtipotarifa(getgxTv_Sdtimportacion_legajo_Migrlegtipotarifa());
      struct.setMigrlegclase(getgxTv_Sdtimportacion_legajo_Migrlegclase());
      struct.setMigrlegbasico(getgxTv_Sdtimportacion_legajo_Migrlegbasico());
      struct.setMigrlegformapago(getgxTv_Sdtimportacion_legajo_Migrlegformapago());
      struct.setMigrlegclasedef(getgxTv_Sdtimportacion_legajo_Migrlegclasedef());
      struct.setMigrlegbanco(getgxTv_Sdtimportacion_legajo_Migrlegbanco());
      struct.setMigrlegbansuc(getgxTv_Sdtimportacion_legajo_Migrlegbansuc());
      struct.setMigrlegbantipcuen(getgxTv_Sdtimportacion_legajo_Migrlegbantipcuen());
      struct.setMigrlegsindicato(getgxTv_Sdtimportacion_legajo_Migrlegsindicato());
      struct.setMigrlegobrasocial(getgxTv_Sdtimportacion_legajo_Migrlegobrasocial());
      struct.setMigrlegosafip(getgxTv_Sdtimportacion_legajo_Migrlegosafip());
      struct.setMigrlegplanmedico(getgxTv_Sdtimportacion_legajo_Migrlegplanmedico());
      struct.setMigrlegactividad(getgxTv_Sdtimportacion_legajo_Migrlegactividad());
      struct.setMigrlegmodalidad(getgxTv_Sdtimportacion_legajo_Migrlegmodalidad());
      struct.setMigrlegfecultmod(getgxTv_Sdtimportacion_legajo_Migrlegfecultmod());
      struct.setMigrlegcuentabanc(getgxTv_Sdtimportacion_legajo_Migrlegcuentabanc());
      struct.setMigrlegzona(getgxTv_Sdtimportacion_legajo_Migrlegzona());
      struct.setMigrlegcbu(getgxTv_Sdtimportacion_legajo_Migrlegcbu());
      struct.setMigrlegscvo(getgxTv_Sdtimportacion_legajo_Migrlegscvo());
      struct.setMigrlegsituacionrevista(getgxTv_Sdtimportacion_legajo_Migrlegsituacionrevista());
      struct.setMigrlegcondicion(getgxTv_Sdtimportacion_legajo_Migrlegcondicion());
      struct.setMigrlegsiniestrado(getgxTv_Sdtimportacion_legajo_Migrlegsiniestrado());
      struct.setMigrlegid(getgxTv_Sdtimportacion_legajo_Migrlegid());
      struct.setMigrlegconvenio(getgxTv_Sdtimportacion_legajo_Migrlegconvenio());
      struct.setMigrlegobs(getgxTv_Sdtimportacion_legajo_Migrlegobs());
      struct.setMigrlegerrores(getgxTv_Sdtimportacion_legajo_Migrlegerrores());
      struct.setMigrlegwarnings(getgxTv_Sdtimportacion_legajo_Migrlegwarnings());
      struct.setMigrtieneconyuge(getgxTv_Sdtimportacion_legajo_Migrtieneconyuge());
      struct.setMigrcantidadhijos(getgxTv_Sdtimportacion_legajo_Migrcantidadhijos());
      struct.setMigrencontroososigla(getgxTv_Sdtimportacion_legajo_Migrencontroososigla());
      struct.setMigrtradiurno(getgxTv_Sdtimportacion_legajo_Migrtradiurno());
      struct.setMigrtranoct(getgxTv_Sdtimportacion_legajo_Migrtranoct());
      struct.setMigrtrains(getgxTv_Sdtimportacion_legajo_Migrtrains());
      struct.setMigrencontroosoafip(getgxTv_Sdtimportacion_legajo_Migrencontroosoafip());
      struct.setMigrsueldos(getgxTv_Sdtimportacion_legajo_Migrsueldos());
      struct.setMigrperiodo(getgxTv_Sdtimportacion_legajo_Migrperiodo());
      struct.setMigrlegmodalidaddef(getgxTv_Sdtimportacion_legajo_Migrlegmodalidaddef());
      struct.setMigrlegzonadef(getgxTv_Sdtimportacion_legajo_Migrlegzonadef());
      struct.setMigrlegsituaciondef(getgxTv_Sdtimportacion_legajo_Migrlegsituaciondef());
      struct.setMigrlegestadocivildef(getgxTv_Sdtimportacion_legajo_Migrlegestadocivildef());
      struct.setMigrlegformapagodef(getgxTv_Sdtimportacion_legajo_Migrlegformapagodef());
      struct.setMigrlegtipocuentadef(getgxTv_Sdtimportacion_legajo_Migrlegtipocuentadef());
      struct.setMigrlegactividaddef(getgxTv_Sdtimportacion_legajo_Migrlegactividaddef());
      struct.setMigrlegcondiciondef(getgxTv_Sdtimportacion_legajo_Migrlegcondiciondef());
      struct.setMigrlegsiniestradodef(getgxTv_Sdtimportacion_legajo_Migrlegsiniestradodef());
      struct.setMigrvalcadasave(getgxTv_Sdtimportacion_legajo_Migrvalcadasave());
      struct.setMigrlegfecegreso(getgxTv_Sdtimportacion_legajo_Migrlegfecegreso());
      struct.setMigrotrosdatos(getgxTv_Sdtimportacion_legajo_Migrotrosdatos());
      struct.setMigrpuesto(getgxTv_Sdtimportacion_legajo_Migrpuesto());
      struct.setMigrlegmarcacct(getgxTv_Sdtimportacion_legajo_Migrlegmarcacct());
      struct.setMigrarchsec(getgxTv_Sdtimportacion_legajo_Migrarchsec());
      struct.setFamilia(getgxTv_Sdtimportacion_legajo_Familia().getStruct());
      struct.setMigrlegactlabclas(getgxTv_Sdtimportacion_legajo_Migrlegactlabclas());
      struct.setMigrlegpueafip(getgxTv_Sdtimportacion_legajo_Migrlegpueafip());
      struct.setMigrleghorsem(getgxTv_Sdtimportacion_legajo_Migrleghorsem());
      struct.setMode(getgxTv_Sdtimportacion_legajo_Mode());
      struct.setInitialized(getgxTv_Sdtimportacion_legajo_Initialized());
      struct.setClicod_Z(getgxTv_Sdtimportacion_legajo_Clicod_Z());
      struct.setEmpcod_Z(getgxTv_Sdtimportacion_legajo_Empcod_Z());
      struct.setMigrlegnumero_Z(getgxTv_Sdtimportacion_legajo_Migrlegnumero_Z());
      struct.setMigrlegapellido_Z(getgxTv_Sdtimportacion_legajo_Migrlegapellido_Z());
      struct.setMigrlegnombre_Z(getgxTv_Sdtimportacion_legajo_Migrlegnombre_Z());
      struct.setMigrlegfecnac_Z(getgxTv_Sdtimportacion_legajo_Migrlegfecnac_Z());
      struct.setMigrlegsexo_Z(getgxTv_Sdtimportacion_legajo_Migrlegsexo_Z());
      struct.setMigrlegestadocivil_Z(getgxTv_Sdtimportacion_legajo_Migrlegestadocivil_Z());
      struct.setMigrlegcuil_Z(getgxTv_Sdtimportacion_legajo_Migrlegcuil_Z());
      struct.setMigrlegdiscapacidad_Z(getgxTv_Sdtimportacion_legajo_Migrlegdiscapacidad_Z());
      struct.setMigrlegdomici_Z(getgxTv_Sdtimportacion_legajo_Migrlegdomici_Z());
      struct.setMigrlegemail_Z(getgxTv_Sdtimportacion_legajo_Migrlegemail_Z());
      struct.setMigrlegcodpos_Z(getgxTv_Sdtimportacion_legajo_Migrlegcodpos_Z());
      struct.setMigrlegtelefono_Z(getgxTv_Sdtimportacion_legajo_Migrlegtelefono_Z());
      struct.setMigrlegfecingreso_Z(getgxTv_Sdtimportacion_legajo_Migrlegfecingreso_Z());
      struct.setMigrlegcategoria_Z(getgxTv_Sdtimportacion_legajo_Migrlegcategoria_Z());
      struct.setMigrlegarea_Z(getgxTv_Sdtimportacion_legajo_Migrlegarea_Z());
      struct.setMigrleglugardepago_Z(getgxTv_Sdtimportacion_legajo_Migrleglugardepago_Z());
      struct.setMigrlegmodtra_Z(getgxTv_Sdtimportacion_legajo_Migrlegmodtra_Z());
      struct.setMigrlegtipotarifa_Z(getgxTv_Sdtimportacion_legajo_Migrlegtipotarifa_Z());
      struct.setMigrlegclase_Z(getgxTv_Sdtimportacion_legajo_Migrlegclase_Z());
      struct.setMigrlegbasico_Z(getgxTv_Sdtimportacion_legajo_Migrlegbasico_Z());
      struct.setMigrlegformapago_Z(getgxTv_Sdtimportacion_legajo_Migrlegformapago_Z());
      struct.setMigrlegclasedef_Z(getgxTv_Sdtimportacion_legajo_Migrlegclasedef_Z());
      struct.setMigrlegbanco_Z(getgxTv_Sdtimportacion_legajo_Migrlegbanco_Z());
      struct.setMigrlegbansuc_Z(getgxTv_Sdtimportacion_legajo_Migrlegbansuc_Z());
      struct.setMigrlegbantipcuen_Z(getgxTv_Sdtimportacion_legajo_Migrlegbantipcuen_Z());
      struct.setMigrlegsindicato_Z(getgxTv_Sdtimportacion_legajo_Migrlegsindicato_Z());
      struct.setMigrlegobrasocial_Z(getgxTv_Sdtimportacion_legajo_Migrlegobrasocial_Z());
      struct.setMigrlegosafip_Z(getgxTv_Sdtimportacion_legajo_Migrlegosafip_Z());
      struct.setMigrlegplanmedico_Z(getgxTv_Sdtimportacion_legajo_Migrlegplanmedico_Z());
      struct.setMigrlegactividad_Z(getgxTv_Sdtimportacion_legajo_Migrlegactividad_Z());
      struct.setMigrlegmodalidad_Z(getgxTv_Sdtimportacion_legajo_Migrlegmodalidad_Z());
      struct.setMigrlegfecultmod_Z(getgxTv_Sdtimportacion_legajo_Migrlegfecultmod_Z());
      struct.setMigrlegcuentabanc_Z(getgxTv_Sdtimportacion_legajo_Migrlegcuentabanc_Z());
      struct.setMigrlegzona_Z(getgxTv_Sdtimportacion_legajo_Migrlegzona_Z());
      struct.setMigrlegcbu_Z(getgxTv_Sdtimportacion_legajo_Migrlegcbu_Z());
      struct.setMigrlegscvo_Z(getgxTv_Sdtimportacion_legajo_Migrlegscvo_Z());
      struct.setMigrlegsituacionrevista_Z(getgxTv_Sdtimportacion_legajo_Migrlegsituacionrevista_Z());
      struct.setMigrlegcondicion_Z(getgxTv_Sdtimportacion_legajo_Migrlegcondicion_Z());
      struct.setMigrlegsiniestrado_Z(getgxTv_Sdtimportacion_legajo_Migrlegsiniestrado_Z());
      struct.setMigrlegid_Z(getgxTv_Sdtimportacion_legajo_Migrlegid_Z());
      struct.setMigrlegconvenio_Z(getgxTv_Sdtimportacion_legajo_Migrlegconvenio_Z());
      struct.setMigrtieneconyuge_Z(getgxTv_Sdtimportacion_legajo_Migrtieneconyuge_Z());
      struct.setMigrcantidadhijos_Z(getgxTv_Sdtimportacion_legajo_Migrcantidadhijos_Z());
      struct.setMigrencontroososigla_Z(getgxTv_Sdtimportacion_legajo_Migrencontroososigla_Z());
      struct.setMigrtradiurno_Z(getgxTv_Sdtimportacion_legajo_Migrtradiurno_Z());
      struct.setMigrtranoct_Z(getgxTv_Sdtimportacion_legajo_Migrtranoct_Z());
      struct.setMigrtrains_Z(getgxTv_Sdtimportacion_legajo_Migrtrains_Z());
      struct.setMigrencontroosoafip_Z(getgxTv_Sdtimportacion_legajo_Migrencontroosoafip_Z());
      struct.setMigrperiodo_Z(getgxTv_Sdtimportacion_legajo_Migrperiodo_Z());
      struct.setMigrlegmodalidaddef_Z(getgxTv_Sdtimportacion_legajo_Migrlegmodalidaddef_Z());
      struct.setMigrlegzonadef_Z(getgxTv_Sdtimportacion_legajo_Migrlegzonadef_Z());
      struct.setMigrlegsituaciondef_Z(getgxTv_Sdtimportacion_legajo_Migrlegsituaciondef_Z());
      struct.setMigrlegestadocivildef_Z(getgxTv_Sdtimportacion_legajo_Migrlegestadocivildef_Z());
      struct.setMigrlegformapagodef_Z(getgxTv_Sdtimportacion_legajo_Migrlegformapagodef_Z());
      struct.setMigrlegtipocuentadef_Z(getgxTv_Sdtimportacion_legajo_Migrlegtipocuentadef_Z());
      struct.setMigrlegactividaddef_Z(getgxTv_Sdtimportacion_legajo_Migrlegactividaddef_Z());
      struct.setMigrlegcondiciondef_Z(getgxTv_Sdtimportacion_legajo_Migrlegcondiciondef_Z());
      struct.setMigrlegsiniestradodef_Z(getgxTv_Sdtimportacion_legajo_Migrlegsiniestradodef_Z());
      struct.setMigrvalcadasave_Z(getgxTv_Sdtimportacion_legajo_Migrvalcadasave_Z());
      struct.setMigrlegfecegreso_Z(getgxTv_Sdtimportacion_legajo_Migrlegfecegreso_Z());
      struct.setMigrpuesto_Z(getgxTv_Sdtimportacion_legajo_Migrpuesto_Z());
      struct.setMigrlegmarcacct_Z(getgxTv_Sdtimportacion_legajo_Migrlegmarcacct_Z());
      struct.setMigrarchsec_Z(getgxTv_Sdtimportacion_legajo_Migrarchsec_Z());
      struct.setMigrlegactlabclas_Z(getgxTv_Sdtimportacion_legajo_Migrlegactlabclas_Z());
      struct.setMigrlegpueafip_Z(getgxTv_Sdtimportacion_legajo_Migrlegpueafip_Z());
      struct.setMigrleghorsem_Z(getgxTv_Sdtimportacion_legajo_Migrleghorsem_Z());
      struct.setMigrlegmarcacct_N(getgxTv_Sdtimportacion_legajo_Migrlegmarcacct_N());
      struct.setMigrarchsec_N(getgxTv_Sdtimportacion_legajo_Migrarchsec_N());
      return struct ;
   }

   private byte gxTv_Sdtimportacion_legajo_N ;
   private byte gxTv_Sdtimportacion_legajo_Migrlegmarcacct_N ;
   private byte gxTv_Sdtimportacion_legajo_Migrarchsec_N ;
   private short gxTv_Sdtimportacion_legajo_Empcod ;
   private short gxTv_Sdtimportacion_legajo_Migrcantidadhijos ;
   private short gxTv_Sdtimportacion_legajo_Migrarchsec ;
   private short gxTv_Sdtimportacion_legajo_Initialized ;
   private short gxTv_Sdtimportacion_legajo_Empcod_Z ;
   private short gxTv_Sdtimportacion_legajo_Migrcantidadhijos_Z ;
   private short gxTv_Sdtimportacion_legajo_Migrarchsec_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_Sdtimportacion_legajo_Clicod ;
   private int gxTv_Sdtimportacion_legajo_Migrlegnumero ;
   private int gxTv_Sdtimportacion_legajo_Clicod_Z ;
   private int gxTv_Sdtimportacion_legajo_Migrlegnumero_Z ;
   private java.math.BigDecimal gxTv_Sdtimportacion_legajo_Migrlegbasico ;
   private java.math.BigDecimal gxTv_Sdtimportacion_legajo_Migrleghorsem ;
   private java.math.BigDecimal gxTv_Sdtimportacion_legajo_Migrlegbasico_Z ;
   private java.math.BigDecimal gxTv_Sdtimportacion_legajo_Migrleghorsem_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegsexo ;
   private String gxTv_Sdtimportacion_legajo_Migrlegcuil ;
   private String gxTv_Sdtimportacion_legajo_Migrlegdiscapacidad ;
   private String gxTv_Sdtimportacion_legajo_Migrlegosafip ;
   private String gxTv_Sdtimportacion_legajo_Migrlegscvo ;
   private String gxTv_Sdtimportacion_legajo_Migrlegid ;
   private String gxTv_Sdtimportacion_legajo_Migrtieneconyuge ;
   private String gxTv_Sdtimportacion_legajo_Migrtradiurno ;
   private String gxTv_Sdtimportacion_legajo_Migrtranoct ;
   private String gxTv_Sdtimportacion_legajo_Migrtrains ;
   private String gxTv_Sdtimportacion_legajo_Migrlegmarcacct ;
   private String gxTv_Sdtimportacion_legajo_Mode ;
   private String gxTv_Sdtimportacion_legajo_Migrlegsexo_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegcuil_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegdiscapacidad_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegosafip_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegscvo_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegid_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrtieneconyuge_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrtradiurno_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrtranoct_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrtrains_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegmarcacct_Z ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_Sdtimportacion_legajo_Migrlegfecnac ;
   private java.util.Date gxTv_Sdtimportacion_legajo_Migrlegfecingreso ;
   private java.util.Date gxTv_Sdtimportacion_legajo_Migrlegfecultmod ;
   private java.util.Date gxTv_Sdtimportacion_legajo_Migrperiodo ;
   private java.util.Date gxTv_Sdtimportacion_legajo_Migrlegfecegreso ;
   private java.util.Date gxTv_Sdtimportacion_legajo_Migrlegfecnac_Z ;
   private java.util.Date gxTv_Sdtimportacion_legajo_Migrlegfecingreso_Z ;
   private java.util.Date gxTv_Sdtimportacion_legajo_Migrlegfecultmod_Z ;
   private java.util.Date gxTv_Sdtimportacion_legajo_Migrperiodo_Z ;
   private java.util.Date gxTv_Sdtimportacion_legajo_Migrlegfecegreso_Z ;
   private boolean gxTv_Sdtimportacion_legajo_Migrlegclasedef ;
   private boolean gxTv_Sdtimportacion_legajo_Migrencontroososigla ;
   private boolean gxTv_Sdtimportacion_legajo_Migrencontroosoafip ;
   private boolean gxTv_Sdtimportacion_legajo_Migrlegmodalidaddef ;
   private boolean gxTv_Sdtimportacion_legajo_Migrlegzonadef ;
   private boolean gxTv_Sdtimportacion_legajo_Migrlegsituaciondef ;
   private boolean gxTv_Sdtimportacion_legajo_Migrlegestadocivildef ;
   private boolean gxTv_Sdtimportacion_legajo_Migrlegformapagodef ;
   private boolean gxTv_Sdtimportacion_legajo_Migrlegtipocuentadef ;
   private boolean gxTv_Sdtimportacion_legajo_Migrlegactividaddef ;
   private boolean gxTv_Sdtimportacion_legajo_Migrlegcondiciondef ;
   private boolean gxTv_Sdtimportacion_legajo_Migrlegsiniestradodef ;
   private boolean gxTv_Sdtimportacion_legajo_Migrvalcadasave ;
   private boolean gxTv_Sdtimportacion_legajo_Migrlegclasedef_Z ;
   private boolean gxTv_Sdtimportacion_legajo_Migrencontroososigla_Z ;
   private boolean gxTv_Sdtimportacion_legajo_Migrencontroosoafip_Z ;
   private boolean gxTv_Sdtimportacion_legajo_Migrlegmodalidaddef_Z ;
   private boolean gxTv_Sdtimportacion_legajo_Migrlegzonadef_Z ;
   private boolean gxTv_Sdtimportacion_legajo_Migrlegsituaciondef_Z ;
   private boolean gxTv_Sdtimportacion_legajo_Migrlegestadocivildef_Z ;
   private boolean gxTv_Sdtimportacion_legajo_Migrlegformapagodef_Z ;
   private boolean gxTv_Sdtimportacion_legajo_Migrlegtipocuentadef_Z ;
   private boolean gxTv_Sdtimportacion_legajo_Migrlegactividaddef_Z ;
   private boolean gxTv_Sdtimportacion_legajo_Migrlegcondiciondef_Z ;
   private boolean gxTv_Sdtimportacion_legajo_Migrlegsiniestradodef_Z ;
   private boolean gxTv_Sdtimportacion_legajo_Migrvalcadasave_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_Sdtimportacion_legajo_Migrlegobs ;
   private String gxTv_Sdtimportacion_legajo_Migrlegerrores ;
   private String gxTv_Sdtimportacion_legajo_Migrlegwarnings ;
   private String gxTv_Sdtimportacion_legajo_Migrsueldos ;
   private String gxTv_Sdtimportacion_legajo_Migrotrosdatos ;
   private String gxTv_Sdtimportacion_legajo_Migrlegapellido ;
   private String gxTv_Sdtimportacion_legajo_Migrlegnombre ;
   private String gxTv_Sdtimportacion_legajo_Migrlegestadocivil ;
   private String gxTv_Sdtimportacion_legajo_Migrlegdomici ;
   private String gxTv_Sdtimportacion_legajo_Migrlegemail ;
   private String gxTv_Sdtimportacion_legajo_Migrlegcodpos ;
   private String gxTv_Sdtimportacion_legajo_Migrlegtelefono ;
   private String gxTv_Sdtimportacion_legajo_Migrlegcategoria ;
   private String gxTv_Sdtimportacion_legajo_Migrlegarea ;
   private String gxTv_Sdtimportacion_legajo_Migrleglugardepago ;
   private String gxTv_Sdtimportacion_legajo_Migrlegmodtra ;
   private String gxTv_Sdtimportacion_legajo_Migrlegtipotarifa ;
   private String gxTv_Sdtimportacion_legajo_Migrlegclase ;
   private String gxTv_Sdtimportacion_legajo_Migrlegformapago ;
   private String gxTv_Sdtimportacion_legajo_Migrlegbanco ;
   private String gxTv_Sdtimportacion_legajo_Migrlegbansuc ;
   private String gxTv_Sdtimportacion_legajo_Migrlegbantipcuen ;
   private String gxTv_Sdtimportacion_legajo_Migrlegsindicato ;
   private String gxTv_Sdtimportacion_legajo_Migrlegobrasocial ;
   private String gxTv_Sdtimportacion_legajo_Migrlegplanmedico ;
   private String gxTv_Sdtimportacion_legajo_Migrlegactividad ;
   private String gxTv_Sdtimportacion_legajo_Migrlegmodalidad ;
   private String gxTv_Sdtimportacion_legajo_Migrlegcuentabanc ;
   private String gxTv_Sdtimportacion_legajo_Migrlegzona ;
   private String gxTv_Sdtimportacion_legajo_Migrlegcbu ;
   private String gxTv_Sdtimportacion_legajo_Migrlegsituacionrevista ;
   private String gxTv_Sdtimportacion_legajo_Migrlegcondicion ;
   private String gxTv_Sdtimportacion_legajo_Migrlegsiniestrado ;
   private String gxTv_Sdtimportacion_legajo_Migrlegconvenio ;
   private String gxTv_Sdtimportacion_legajo_Migrpuesto ;
   private String gxTv_Sdtimportacion_legajo_Migrlegactlabclas ;
   private String gxTv_Sdtimportacion_legajo_Migrlegpueafip ;
   private String gxTv_Sdtimportacion_legajo_Migrlegapellido_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegnombre_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegestadocivil_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegdomici_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegemail_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegcodpos_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegtelefono_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegcategoria_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegarea_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrleglugardepago_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegmodtra_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegtipotarifa_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegclase_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegformapago_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegbanco_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegbansuc_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegbantipcuen_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegsindicato_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegobrasocial_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegplanmedico_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegactividad_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegmodalidad_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegcuentabanc_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegzona_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegcbu_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegsituacionrevista_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegcondicion_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegsiniestrado_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegconvenio_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrpuesto_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegactlabclas_Z ;
   private String gxTv_Sdtimportacion_legajo_Migrlegpueafip_Z ;
   private GXBCLevelCollection<web.Sdtimportacion_legajo_Familia> gxTv_Sdtimportacion_legajo_Familia_aux ;
   private GXBCLevelCollection<web.Sdtimportacion_legajo_Familia> gxTv_Sdtimportacion_legajo_Familia=null ;
}

