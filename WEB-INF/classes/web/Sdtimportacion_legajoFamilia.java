package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtimportacion_legajoFamilia extends GxSilentTrnSdt
{
   public Sdtimportacion_legajoFamilia( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(Sdtimportacion_legajoFamilia.class));
   }

   public Sdtimportacion_legajoFamilia( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle, context, "Sdtimportacion_legajoFamilia");
      initialize( remoteHandle) ;
   }

   public Sdtimportacion_legajoFamilia( int remoteHandle ,
                                        StructSdtimportacion_legajoFamilia struct )
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
                     int AV87MigrLegNumero ,
                     short AV2078MigrLegFamSec )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV3CliCod),Short.valueOf(AV1EmpCod),Integer.valueOf(AV87MigrLegNumero),Short.valueOf(AV2078MigrLegFamSec)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CliCod", int.class}, new Object[]{"EmpCod", short.class}, new Object[]{"MigrLegNumero", int.class}, new Object[]{"MigrLegFamSec", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "importacion_legajoFamilia");
      metadata.set("BT", "importacion_legajoFamilia");
      metadata.set("PK", "[ \"CliCod\",\"EmpCod\",\"MigrLegNumero\",\"MigrLegFamSec\" ]");
      metadata.set("PKAssigned", "[ \"CliCod\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\",\"EmpCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"EmpCod\",\"MigrLegNumero\" ],\"FKMap\":[  ] } ]");
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
               gxTv_Sdtimportacion_legajoFamilia_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod") )
            {
               gxTv_Sdtimportacion_legajoFamilia_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegNumero") )
            {
               gxTv_Sdtimportacion_legajoFamilia_Migrlegnumero = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamSec") )
            {
               gxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamParen") )
            {
               gxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamDiscap") )
            {
               gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamNroDoc") )
            {
               gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamDedGan") )
            {
               gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamAdh") )
            {
               gxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamErrores") )
            {
               gxTv_Sdtimportacion_legajoFamilia_Migrlegfamerrores = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamWarnings") )
            {
               gxTv_Sdtimportacion_legajoFamilia_Migrlegfamwarnings = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegApellido") )
            {
               gxTv_Sdtimportacion_legajoFamilia_Migrlegapellido = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegNombre") )
            {
               gxTv_Sdtimportacion_legajoFamilia_Migrlegnombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegCUIL") )
            {
               gxTv_Sdtimportacion_legajoFamilia_Migrlegcuil = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamNomApe") )
            {
               gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamFecNac") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_Sdtimportacion_legajoFamilia_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_Sdtimportacion_legajoFamilia_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_Sdtimportacion_legajoFamilia_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod_Z") )
            {
               gxTv_Sdtimportacion_legajoFamilia_Empcod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegNumero_Z") )
            {
               gxTv_Sdtimportacion_legajoFamilia_Migrlegnumero_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamSec_Z") )
            {
               gxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamParen_Z") )
            {
               gxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamDiscap_Z") )
            {
               gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamNroDoc_Z") )
            {
               gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamDedGan_Z") )
            {
               gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamAdh_Z") )
            {
               gxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegApellido_Z") )
            {
               gxTv_Sdtimportacion_legajoFamilia_Migrlegapellido_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegNombre_Z") )
            {
               gxTv_Sdtimportacion_legajoFamilia_Migrlegnombre_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegCUIL_Z") )
            {
               gxTv_Sdtimportacion_legajoFamilia_Migrlegcuil_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamNomApe_Z") )
            {
               gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegFamFecNac_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
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
         sName = "importacion_legajoFamilia" ;
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
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_legajoFamilia_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCod", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_legajoFamilia_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegNumero", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_legajoFamilia_Migrlegnumero, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegFamSec", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegFamParen", gxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegFamDiscap", gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegFamNroDoc", gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegFamDedGan", GXutil.trim( GXutil.strNoRound( gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegFamAdh", gxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegFamErrores", gxTv_Sdtimportacion_legajoFamilia_Migrlegfamerrores);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegFamWarnings", gxTv_Sdtimportacion_legajoFamilia_Migrlegfamwarnings);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegApellido", gxTv_Sdtimportacion_legajoFamilia_Migrlegapellido);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegNombre", gxTv_Sdtimportacion_legajoFamilia_Migrlegnombre);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegCUIL", gxTv_Sdtimportacion_legajoFamilia_Migrlegcuil);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegFamNomApe", gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("MigrLegFamFecNac", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_Sdtimportacion_legajoFamilia_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_legajoFamilia_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_legajoFamilia_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpCod_Z", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_legajoFamilia_Empcod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegNumero_Z", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_legajoFamilia_Migrlegnumero_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegFamSec_Z", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegFamParen_Z", gxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegFamDiscap_Z", gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegFamNroDoc_Z", gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegFamDedGan_Z", GXutil.trim( GXutil.strNoRound( gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan_Z, 6, 4)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegFamAdh_Z", gxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegApellido_Z", gxTv_Sdtimportacion_legajoFamilia_Migrlegapellido_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegNombre_Z", gxTv_Sdtimportacion_legajoFamilia_Migrlegnombre_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegCUIL_Z", gxTv_Sdtimportacion_legajoFamilia_Migrlegcuil_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MigrLegFamNomApe_Z", gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("MigrLegFamFecNac_Z", sDateCnv);
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
      AddObjectProperty("CliCod", gxTv_Sdtimportacion_legajoFamilia_Clicod, false, includeNonInitialized);
      AddObjectProperty("EmpCod", gxTv_Sdtimportacion_legajoFamilia_Empcod, false, includeNonInitialized);
      AddObjectProperty("MigrLegNumero", gxTv_Sdtimportacion_legajoFamilia_Migrlegnumero, false, includeNonInitialized);
      AddObjectProperty("MigrLegFamSec", gxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec, false, includeNonInitialized);
      AddObjectProperty("MigrLegFamParen", gxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen, false, includeNonInitialized);
      AddObjectProperty("MigrLegFamDiscap", gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap, false, includeNonInitialized);
      AddObjectProperty("MigrLegFamNroDoc", gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc, false, includeNonInitialized);
      AddObjectProperty("MigrLegFamDedGan", gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan, false, includeNonInitialized);
      AddObjectProperty("MigrLegFamAdh", gxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh, false, includeNonInitialized);
      AddObjectProperty("MigrLegFamErrores", gxTv_Sdtimportacion_legajoFamilia_Migrlegfamerrores, false, includeNonInitialized);
      AddObjectProperty("MigrLegFamWarnings", gxTv_Sdtimportacion_legajoFamilia_Migrlegfamwarnings, false, includeNonInitialized);
      AddObjectProperty("MigrLegApellido", gxTv_Sdtimportacion_legajoFamilia_Migrlegapellido, false, includeNonInitialized);
      AddObjectProperty("MigrLegNombre", gxTv_Sdtimportacion_legajoFamilia_Migrlegnombre, false, includeNonInitialized);
      AddObjectProperty("MigrLegCUIL", gxTv_Sdtimportacion_legajoFamilia_Migrlegcuil, false, includeNonInitialized);
      AddObjectProperty("MigrLegFamNomApe", gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("MigrLegFamFecNac", sDateCnv, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_Sdtimportacion_legajoFamilia_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_Sdtimportacion_legajoFamilia_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_Sdtimportacion_legajoFamilia_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpCod_Z", gxTv_Sdtimportacion_legajoFamilia_Empcod_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegNumero_Z", gxTv_Sdtimportacion_legajoFamilia_Migrlegnumero_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegFamSec_Z", gxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegFamParen_Z", gxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegFamDiscap_Z", gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegFamNroDoc_Z", gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegFamDedGan_Z", gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegFamAdh_Z", gxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegApellido_Z", gxTv_Sdtimportacion_legajoFamilia_Migrlegapellido_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegNombre_Z", gxTv_Sdtimportacion_legajoFamilia_Migrlegnombre_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegCUIL_Z", gxTv_Sdtimportacion_legajoFamilia_Migrlegcuil_Z, false, includeNonInitialized);
         AddObjectProperty("MigrLegFamNomApe_Z", gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("MigrLegFamFecNac_Z", sDateCnv, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.Sdtimportacion_legajoFamilia sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajoFamilia_Clicod = sdt.getgxTv_Sdtimportacion_legajoFamilia_Clicod() ;
      }
      if ( sdt.IsDirty("EmpCod") )
      {
         gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajoFamilia_Empcod = sdt.getgxTv_Sdtimportacion_legajoFamilia_Empcod() ;
      }
      if ( sdt.IsDirty("MigrLegNumero") )
      {
         gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajoFamilia_Migrlegnumero = sdt.getgxTv_Sdtimportacion_legajoFamilia_Migrlegnumero() ;
      }
      if ( sdt.IsDirty("MigrLegFamSec") )
      {
         gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec = sdt.getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec() ;
      }
      if ( sdt.IsDirty("MigrLegFamParen") )
      {
         gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen = sdt.getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen() ;
      }
      if ( sdt.IsDirty("MigrLegFamDiscap") )
      {
         gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap = sdt.getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap() ;
      }
      if ( sdt.IsDirty("MigrLegFamNroDoc") )
      {
         gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc = sdt.getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc() ;
      }
      if ( sdt.IsDirty("MigrLegFamDedGan") )
      {
         gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan = sdt.getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan() ;
      }
      if ( sdt.IsDirty("MigrLegFamAdh") )
      {
         gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh = sdt.getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh() ;
      }
      if ( sdt.IsDirty("MigrLegFamErrores") )
      {
         gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajoFamilia_Migrlegfamerrores = sdt.getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamerrores() ;
      }
      if ( sdt.IsDirty("MigrLegFamWarnings") )
      {
         gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajoFamilia_Migrlegfamwarnings = sdt.getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamwarnings() ;
      }
      if ( sdt.IsDirty("MigrLegApellido") )
      {
         gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajoFamilia_Migrlegapellido = sdt.getgxTv_Sdtimportacion_legajoFamilia_Migrlegapellido() ;
      }
      if ( sdt.IsDirty("MigrLegNombre") )
      {
         gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajoFamilia_Migrlegnombre = sdt.getgxTv_Sdtimportacion_legajoFamilia_Migrlegnombre() ;
      }
      if ( sdt.IsDirty("MigrLegCUIL") )
      {
         gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajoFamilia_Migrlegcuil = sdt.getgxTv_Sdtimportacion_legajoFamilia_Migrlegcuil() ;
      }
      if ( sdt.IsDirty("MigrLegFamNomApe") )
      {
         gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape = sdt.getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape() ;
      }
      if ( sdt.IsDirty("MigrLegFamFecNac") )
      {
         gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
         gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac = sdt.getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac() ;
      }
   }

   public int getgxTv_Sdtimportacion_legajoFamilia_Clicod( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Clicod ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Clicod( int value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      if ( gxTv_Sdtimportacion_legajoFamilia_Clicod != value )
      {
         gxTv_Sdtimportacion_legajoFamilia_Mode = "INS" ;
         this.setgxTv_Sdtimportacion_legajoFamilia_Clicod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Empcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegnumero_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegapellido_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegnombre_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegcuil_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac_Z_SetNull( );
      }
      SetDirty("Clicod");
      gxTv_Sdtimportacion_legajoFamilia_Clicod = value ;
   }

   public short getgxTv_Sdtimportacion_legajoFamilia_Empcod( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Empcod ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Empcod( short value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      if ( gxTv_Sdtimportacion_legajoFamilia_Empcod != value )
      {
         gxTv_Sdtimportacion_legajoFamilia_Mode = "INS" ;
         this.setgxTv_Sdtimportacion_legajoFamilia_Clicod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Empcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegnumero_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegapellido_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegnombre_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegcuil_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac_Z_SetNull( );
      }
      SetDirty("Empcod");
      gxTv_Sdtimportacion_legajoFamilia_Empcod = value ;
   }

   public int getgxTv_Sdtimportacion_legajoFamilia_Migrlegnumero( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegnumero ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegnumero( int value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      if ( gxTv_Sdtimportacion_legajoFamilia_Migrlegnumero != value )
      {
         gxTv_Sdtimportacion_legajoFamilia_Mode = "INS" ;
         this.setgxTv_Sdtimportacion_legajoFamilia_Clicod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Empcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegnumero_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegapellido_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegnombre_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegcuil_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac_Z_SetNull( );
      }
      SetDirty("Migrlegnumero");
      gxTv_Sdtimportacion_legajoFamilia_Migrlegnumero = value ;
   }

   public short getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec( short value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      if ( gxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec != value )
      {
         gxTv_Sdtimportacion_legajoFamilia_Mode = "INS" ;
         this.setgxTv_Sdtimportacion_legajoFamilia_Clicod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Empcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegnumero_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegapellido_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegnombre_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegcuil_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape_Z_SetNull( );
         this.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac_Z_SetNull( );
      }
      SetDirty("Migrlegfamsec");
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec = value ;
   }

   public String getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      SetDirty("Migrlegfamparen");
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen = value ;
   }

   public String getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      SetDirty("Migrlegfamdiscap");
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap = value ;
   }

   public String getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      SetDirty("Migrlegfamnrodoc");
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan( java.math.BigDecimal value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      SetDirty("Migrlegfamdedgan");
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan = value ;
   }

   public String getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      SetDirty("Migrlegfamadh");
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh = value ;
   }

   public String getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamerrores( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamerrores ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamerrores( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      SetDirty("Migrlegfamerrores");
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamerrores = value ;
   }

   public String getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamwarnings( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamwarnings ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamwarnings( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      SetDirty("Migrlegfamwarnings");
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamwarnings = value ;
   }

   public String getgxTv_Sdtimportacion_legajoFamilia_Migrlegapellido( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegapellido ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegapellido( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      SetDirty("Migrlegapellido");
      gxTv_Sdtimportacion_legajoFamilia_Migrlegapellido = value ;
   }

   public String getgxTv_Sdtimportacion_legajoFamilia_Migrlegnombre( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegnombre ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegnombre( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      SetDirty("Migrlegnombre");
      gxTv_Sdtimportacion_legajoFamilia_Migrlegnombre = value ;
   }

   public String getgxTv_Sdtimportacion_legajoFamilia_Migrlegcuil( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegcuil ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegcuil( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      SetDirty("Migrlegcuil");
      gxTv_Sdtimportacion_legajoFamilia_Migrlegcuil = value ;
   }

   public String getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      SetDirty("Migrlegfamnomape");
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape = value ;
   }

   public java.util.Date getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac( java.util.Date value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      SetDirty("Migrlegfamfecnac");
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac = value ;
   }

   public String getgxTv_Sdtimportacion_legajoFamilia_Mode( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Mode ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Mode( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_Sdtimportacion_legajoFamilia_Mode = value ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Mode_SetNull( )
   {
      gxTv_Sdtimportacion_legajoFamilia_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_Sdtimportacion_legajoFamilia_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtimportacion_legajoFamilia_Initialized( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Initialized ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Initialized( short value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_Sdtimportacion_legajoFamilia_Initialized = value ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Initialized_SetNull( )
   {
      gxTv_Sdtimportacion_legajoFamilia_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_Sdtimportacion_legajoFamilia_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_Sdtimportacion_legajoFamilia_Clicod_Z( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Clicod_Z ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Clicod_Z( int value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_Sdtimportacion_legajoFamilia_Clicod_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Clicod_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajoFamilia_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajoFamilia_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtimportacion_legajoFamilia_Empcod_Z( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Empcod_Z ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Empcod_Z( short value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      SetDirty("Empcod_Z");
      gxTv_Sdtimportacion_legajoFamilia_Empcod_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Empcod_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajoFamilia_Empcod_Z = (short)(0) ;
      SetDirty("Empcod_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajoFamilia_Empcod_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_Sdtimportacion_legajoFamilia_Migrlegnumero_Z( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegnumero_Z ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegnumero_Z( int value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      SetDirty("Migrlegnumero_Z");
      gxTv_Sdtimportacion_legajoFamilia_Migrlegnumero_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegnumero_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajoFamilia_Migrlegnumero_Z = 0 ;
      SetDirty("Migrlegnumero_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajoFamilia_Migrlegnumero_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec_Z( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec_Z ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec_Z( short value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      SetDirty("Migrlegfamsec_Z");
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec_Z = (short)(0) ;
      SetDirty("Migrlegfamsec_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen_Z( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen_Z ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen_Z( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      SetDirty("Migrlegfamparen_Z");
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen_Z = "" ;
      SetDirty("Migrlegfamparen_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap_Z( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap_Z ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap_Z( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      SetDirty("Migrlegfamdiscap_Z");
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap_Z = "" ;
      SetDirty("Migrlegfamdiscap_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc_Z( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc_Z ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc_Z( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      SetDirty("Migrlegfamnrodoc_Z");
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc_Z = "" ;
      SetDirty("Migrlegfamnrodoc_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan_Z( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan_Z ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan_Z( java.math.BigDecimal value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      SetDirty("Migrlegfamdedgan_Z");
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan_Z = DecimalUtil.ZERO ;
      SetDirty("Migrlegfamdedgan_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh_Z( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh_Z ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh_Z( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      SetDirty("Migrlegfamadh_Z");
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh_Z = "" ;
      SetDirty("Migrlegfamadh_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajoFamilia_Migrlegapellido_Z( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegapellido_Z ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegapellido_Z( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      SetDirty("Migrlegapellido_Z");
      gxTv_Sdtimportacion_legajoFamilia_Migrlegapellido_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegapellido_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajoFamilia_Migrlegapellido_Z = "" ;
      SetDirty("Migrlegapellido_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajoFamilia_Migrlegapellido_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajoFamilia_Migrlegnombre_Z( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegnombre_Z ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegnombre_Z( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      SetDirty("Migrlegnombre_Z");
      gxTv_Sdtimportacion_legajoFamilia_Migrlegnombre_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegnombre_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajoFamilia_Migrlegnombre_Z = "" ;
      SetDirty("Migrlegnombre_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajoFamilia_Migrlegnombre_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajoFamilia_Migrlegcuil_Z( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegcuil_Z ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegcuil_Z( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      SetDirty("Migrlegcuil_Z");
      gxTv_Sdtimportacion_legajoFamilia_Migrlegcuil_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegcuil_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajoFamilia_Migrlegcuil_Z = "" ;
      SetDirty("Migrlegcuil_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajoFamilia_Migrlegcuil_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape_Z( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape_Z ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape_Z( String value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      SetDirty("Migrlegfamnomape_Z");
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape_Z = "" ;
      SetDirty("Migrlegfamnomape_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac_Z( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac_Z ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac_Z( java.util.Date value )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(0) ;
      SetDirty("Migrlegfamfecnac_Z");
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac_Z = value ;
   }

   public void setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac_Z_SetNull( )
   {
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac_Z = GXutil.nullDate() ;
      SetDirty("Migrlegfamfecnac_Z");
   }

   public boolean getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.importacion_legajofamilia_bc obj;
      obj = new web.importacion_legajofamilia_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_Sdtimportacion_legajoFamilia_N = (byte)(1) ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan = DecimalUtil.ZERO ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamerrores = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamwarnings = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegapellido = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegnombre = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegcuil = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac = GXutil.nullDate() ;
      gxTv_Sdtimportacion_legajoFamilia_Mode = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen_Z = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap_Z = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc_Z = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan_Z = DecimalUtil.ZERO ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh_Z = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegapellido_Z = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegnombre_Z = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegcuil_Z = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape_Z = "" ;
      gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac_Z = GXutil.nullDate() ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtimportacion_legajoFamilia_N ;
   }

   public web.Sdtimportacion_legajoFamilia Clone( )
   {
      web.Sdtimportacion_legajoFamilia sdt;
      web.importacion_legajofamilia_bc obj;
      sdt = (web.Sdtimportacion_legajoFamilia)(clone()) ;
      obj = (web.importacion_legajofamilia_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtimportacion_legajoFamilia struct )
   {
      setgxTv_Sdtimportacion_legajoFamilia_Clicod(struct.getClicod());
      setgxTv_Sdtimportacion_legajoFamilia_Empcod(struct.getEmpcod());
      setgxTv_Sdtimportacion_legajoFamilia_Migrlegnumero(struct.getMigrlegnumero());
      setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec(struct.getMigrlegfamsec());
      setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen(struct.getMigrlegfamparen());
      setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap(struct.getMigrlegfamdiscap());
      setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc(struct.getMigrlegfamnrodoc());
      setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan(struct.getMigrlegfamdedgan());
      setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh(struct.getMigrlegfamadh());
      setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamerrores(struct.getMigrlegfamerrores());
      setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamwarnings(struct.getMigrlegfamwarnings());
      setgxTv_Sdtimportacion_legajoFamilia_Migrlegapellido(struct.getMigrlegapellido());
      setgxTv_Sdtimportacion_legajoFamilia_Migrlegnombre(struct.getMigrlegnombre());
      setgxTv_Sdtimportacion_legajoFamilia_Migrlegcuil(struct.getMigrlegcuil());
      setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape(struct.getMigrlegfamnomape());
      setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac(struct.getMigrlegfamfecnac());
      setgxTv_Sdtimportacion_legajoFamilia_Mode(struct.getMode());
      setgxTv_Sdtimportacion_legajoFamilia_Initialized(struct.getInitialized());
      setgxTv_Sdtimportacion_legajoFamilia_Clicod_Z(struct.getClicod_Z());
      setgxTv_Sdtimportacion_legajoFamilia_Empcod_Z(struct.getEmpcod_Z());
      setgxTv_Sdtimportacion_legajoFamilia_Migrlegnumero_Z(struct.getMigrlegnumero_Z());
      setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec_Z(struct.getMigrlegfamsec_Z());
      setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen_Z(struct.getMigrlegfamparen_Z());
      setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap_Z(struct.getMigrlegfamdiscap_Z());
      setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc_Z(struct.getMigrlegfamnrodoc_Z());
      setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan_Z(struct.getMigrlegfamdedgan_Z());
      setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh_Z(struct.getMigrlegfamadh_Z());
      setgxTv_Sdtimportacion_legajoFamilia_Migrlegapellido_Z(struct.getMigrlegapellido_Z());
      setgxTv_Sdtimportacion_legajoFamilia_Migrlegnombre_Z(struct.getMigrlegnombre_Z());
      setgxTv_Sdtimportacion_legajoFamilia_Migrlegcuil_Z(struct.getMigrlegcuil_Z());
      setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape_Z(struct.getMigrlegfamnomape_Z());
      setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac_Z(struct.getMigrlegfamfecnac_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtimportacion_legajoFamilia getStruct( )
   {
      web.StructSdtimportacion_legajoFamilia struct = new web.StructSdtimportacion_legajoFamilia ();
      struct.setClicod(getgxTv_Sdtimportacion_legajoFamilia_Clicod());
      struct.setEmpcod(getgxTv_Sdtimportacion_legajoFamilia_Empcod());
      struct.setMigrlegnumero(getgxTv_Sdtimportacion_legajoFamilia_Migrlegnumero());
      struct.setMigrlegfamsec(getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec());
      struct.setMigrlegfamparen(getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen());
      struct.setMigrlegfamdiscap(getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap());
      struct.setMigrlegfamnrodoc(getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc());
      struct.setMigrlegfamdedgan(getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan());
      struct.setMigrlegfamadh(getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh());
      struct.setMigrlegfamerrores(getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamerrores());
      struct.setMigrlegfamwarnings(getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamwarnings());
      struct.setMigrlegapellido(getgxTv_Sdtimportacion_legajoFamilia_Migrlegapellido());
      struct.setMigrlegnombre(getgxTv_Sdtimportacion_legajoFamilia_Migrlegnombre());
      struct.setMigrlegcuil(getgxTv_Sdtimportacion_legajoFamilia_Migrlegcuil());
      struct.setMigrlegfamnomape(getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape());
      struct.setMigrlegfamfecnac(getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac());
      struct.setMode(getgxTv_Sdtimportacion_legajoFamilia_Mode());
      struct.setInitialized(getgxTv_Sdtimportacion_legajoFamilia_Initialized());
      struct.setClicod_Z(getgxTv_Sdtimportacion_legajoFamilia_Clicod_Z());
      struct.setEmpcod_Z(getgxTv_Sdtimportacion_legajoFamilia_Empcod_Z());
      struct.setMigrlegnumero_Z(getgxTv_Sdtimportacion_legajoFamilia_Migrlegnumero_Z());
      struct.setMigrlegfamsec_Z(getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec_Z());
      struct.setMigrlegfamparen_Z(getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen_Z());
      struct.setMigrlegfamdiscap_Z(getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap_Z());
      struct.setMigrlegfamnrodoc_Z(getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc_Z());
      struct.setMigrlegfamdedgan_Z(getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan_Z());
      struct.setMigrlegfamadh_Z(getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh_Z());
      struct.setMigrlegapellido_Z(getgxTv_Sdtimportacion_legajoFamilia_Migrlegapellido_Z());
      struct.setMigrlegnombre_Z(getgxTv_Sdtimportacion_legajoFamilia_Migrlegnombre_Z());
      struct.setMigrlegcuil_Z(getgxTv_Sdtimportacion_legajoFamilia_Migrlegcuil_Z());
      struct.setMigrlegfamnomape_Z(getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape_Z());
      struct.setMigrlegfamfecnac_Z(getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac_Z());
      return struct ;
   }

   private byte gxTv_Sdtimportacion_legajoFamilia_N ;
   private short gxTv_Sdtimportacion_legajoFamilia_Empcod ;
   private short gxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec ;
   private short gxTv_Sdtimportacion_legajoFamilia_Initialized ;
   private short gxTv_Sdtimportacion_legajoFamilia_Empcod_Z ;
   private short gxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_Sdtimportacion_legajoFamilia_Clicod ;
   private int gxTv_Sdtimportacion_legajoFamilia_Migrlegnumero ;
   private int gxTv_Sdtimportacion_legajoFamilia_Clicod_Z ;
   private int gxTv_Sdtimportacion_legajoFamilia_Migrlegnumero_Z ;
   private java.math.BigDecimal gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan ;
   private java.math.BigDecimal gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan_Z ;
   private String gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap ;
   private String gxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh ;
   private String gxTv_Sdtimportacion_legajoFamilia_Migrlegcuil ;
   private String gxTv_Sdtimportacion_legajoFamilia_Mode ;
   private String gxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap_Z ;
   private String gxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh_Z ;
   private String gxTv_Sdtimportacion_legajoFamilia_Migrlegcuil_Z ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac ;
   private java.util.Date gxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_Sdtimportacion_legajoFamilia_Migrlegfamerrores ;
   private String gxTv_Sdtimportacion_legajoFamilia_Migrlegfamwarnings ;
   private String gxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen ;
   private String gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc ;
   private String gxTv_Sdtimportacion_legajoFamilia_Migrlegapellido ;
   private String gxTv_Sdtimportacion_legajoFamilia_Migrlegnombre ;
   private String gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape ;
   private String gxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen_Z ;
   private String gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc_Z ;
   private String gxTv_Sdtimportacion_legajoFamilia_Migrlegapellido_Z ;
   private String gxTv_Sdtimportacion_legajoFamilia_Migrlegnombre_Z ;
   private String gxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape_Z ;
}

