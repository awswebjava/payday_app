package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSeccion extends GxSilentTrnSdt
{
   public SdtSeccion( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtSeccion.class));
   }

   public SdtSeccion( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle, context, "SdtSeccion");
      initialize( remoteHandle) ;
   }

   public SdtSeccion( int remoteHandle ,
                      StructSdtSeccion struct )
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
                     String AV13SecCodigo )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV3CliCod),AV13SecCodigo});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CliCod", int.class}, new Object[]{"SecCodigo", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Seccion");
      metadata.set("BT", "Seccion");
      metadata.set("PK", "[ \"CliCod\",\"SecCodigo\" ]");
      metadata.set("PKAssigned", "[ \"CliCod\" ]");
      metadata.set("Levels", "[ \"Puestos\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\" ],\"FKMap\":[  ] } ]");
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
               gxTv_SdtSeccion_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecCodigo") )
            {
               gxTv_SdtSeccion_Seccodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecDescrip") )
            {
               gxTv_SdtSeccion_Secdescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecHabilitada") )
            {
               gxTv_SdtSeccion_Sechabilitada = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecDescripSinAc") )
            {
               gxTv_SdtSeccion_Secdescripsinac = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecRelSec") )
            {
               gxTv_SdtSeccion_Secrelsec = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecRelSecCli") )
            {
               gxTv_SdtSeccion_Secrelseccli = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecPadre") )
            {
               gxTv_SdtSeccion_Secpadre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecRelRef") )
            {
               gxTv_SdtSeccion_Secrelref = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecOld") )
            {
               gxTv_SdtSeccion_Secold = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecApoOpc") )
            {
               gxTv_SdtSeccion_Secapoopc = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Puestos") )
            {
               if ( gxTv_SdtSeccion_Puestos == null )
               {
                  gxTv_SdtSeccion_Puestos = new GXBCLevelCollection<web.SdtSeccion_Puestos>(web.SdtSeccion_Puestos.class, "Seccion.Puestos", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtSeccion_Puestos.readxml(oReader, "Puestos") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Puestos") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtSeccion_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtSeccion_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_SdtSeccion_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecCodigo_Z") )
            {
               gxTv_SdtSeccion_Seccodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecDescrip_Z") )
            {
               gxTv_SdtSeccion_Secdescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecHabilitada_Z") )
            {
               gxTv_SdtSeccion_Sechabilitada_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecDescripSinAc_Z") )
            {
               gxTv_SdtSeccion_Secdescripsinac_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecRelSec_Z") )
            {
               gxTv_SdtSeccion_Secrelsec_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecRelSecCli_Z") )
            {
               gxTv_SdtSeccion_Secrelseccli_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecPadre_Z") )
            {
               gxTv_SdtSeccion_Secpadre_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecRelRef_Z") )
            {
               gxTv_SdtSeccion_Secrelref_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecApoOpc_Z") )
            {
               gxTv_SdtSeccion_Secapoopc_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
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
         sName = "Seccion" ;
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
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_SdtSeccion_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SecCodigo", gxTv_SdtSeccion_Seccodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SecDescrip", gxTv_SdtSeccion_Secdescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SecHabilitada", GXutil.booltostr( gxTv_SdtSeccion_Sechabilitada));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SecDescripSinAc", gxTv_SdtSeccion_Secdescripsinac);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SecRelSec", GXutil.trim( GXutil.str( gxTv_SdtSeccion_Secrelsec, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SecRelSecCli", GXutil.trim( GXutil.str( gxTv_SdtSeccion_Secrelseccli, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SecPadre", gxTv_SdtSeccion_Secpadre);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SecRelRef", gxTv_SdtSeccion_Secrelref);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SecOld", gxTv_SdtSeccion_Secold);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SecApoOpc", GXutil.booltostr( gxTv_SdtSeccion_Secapoopc));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_SdtSeccion_Puestos != null )
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
         gxTv_SdtSeccion_Puestos.writexml(oWriter, "Puestos", sNameSpace1, sIncludeState);
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtSeccion_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtSeccion_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_SdtSeccion_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SecCodigo_Z", gxTv_SdtSeccion_Seccodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SecDescrip_Z", gxTv_SdtSeccion_Secdescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SecHabilitada_Z", GXutil.booltostr( gxTv_SdtSeccion_Sechabilitada_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SecDescripSinAc_Z", gxTv_SdtSeccion_Secdescripsinac_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SecRelSec_Z", GXutil.trim( GXutil.str( gxTv_SdtSeccion_Secrelsec_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SecRelSecCli_Z", GXutil.trim( GXutil.str( gxTv_SdtSeccion_Secrelseccli_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SecPadre_Z", gxTv_SdtSeccion_Secpadre_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SecRelRef_Z", gxTv_SdtSeccion_Secrelref_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SecApoOpc_Z", GXutil.booltostr( gxTv_SdtSeccion_Secapoopc_Z));
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
      AddObjectProperty("CliCod", gxTv_SdtSeccion_Clicod, false, includeNonInitialized);
      AddObjectProperty("SecCodigo", gxTv_SdtSeccion_Seccodigo, false, includeNonInitialized);
      AddObjectProperty("SecDescrip", gxTv_SdtSeccion_Secdescrip, false, includeNonInitialized);
      AddObjectProperty("SecHabilitada", gxTv_SdtSeccion_Sechabilitada, false, includeNonInitialized);
      AddObjectProperty("SecDescripSinAc", gxTv_SdtSeccion_Secdescripsinac, false, includeNonInitialized);
      AddObjectProperty("SecRelSec", gxTv_SdtSeccion_Secrelsec, false, includeNonInitialized);
      AddObjectProperty("SecRelSecCli", gxTv_SdtSeccion_Secrelseccli, false, includeNonInitialized);
      AddObjectProperty("SecPadre", gxTv_SdtSeccion_Secpadre, false, includeNonInitialized);
      AddObjectProperty("SecRelRef", gxTv_SdtSeccion_Secrelref, false, includeNonInitialized);
      AddObjectProperty("SecOld", gxTv_SdtSeccion_Secold, false, includeNonInitialized);
      AddObjectProperty("SecApoOpc", gxTv_SdtSeccion_Secapoopc, false, includeNonInitialized);
      if ( gxTv_SdtSeccion_Puestos != null )
      {
         AddObjectProperty("Puestos", gxTv_SdtSeccion_Puestos, includeState, includeNonInitialized);
      }
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtSeccion_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtSeccion_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_SdtSeccion_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("SecCodigo_Z", gxTv_SdtSeccion_Seccodigo_Z, false, includeNonInitialized);
         AddObjectProperty("SecDescrip_Z", gxTv_SdtSeccion_Secdescrip_Z, false, includeNonInitialized);
         AddObjectProperty("SecHabilitada_Z", gxTv_SdtSeccion_Sechabilitada_Z, false, includeNonInitialized);
         AddObjectProperty("SecDescripSinAc_Z", gxTv_SdtSeccion_Secdescripsinac_Z, false, includeNonInitialized);
         AddObjectProperty("SecRelSec_Z", gxTv_SdtSeccion_Secrelsec_Z, false, includeNonInitialized);
         AddObjectProperty("SecRelSecCli_Z", gxTv_SdtSeccion_Secrelseccli_Z, false, includeNonInitialized);
         AddObjectProperty("SecPadre_Z", gxTv_SdtSeccion_Secpadre_Z, false, includeNonInitialized);
         AddObjectProperty("SecRelRef_Z", gxTv_SdtSeccion_Secrelref_Z, false, includeNonInitialized);
         AddObjectProperty("SecApoOpc_Z", gxTv_SdtSeccion_Secapoopc_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtSeccion sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_SdtSeccion_N = (byte)(0) ;
         gxTv_SdtSeccion_Clicod = sdt.getgxTv_SdtSeccion_Clicod() ;
      }
      if ( sdt.IsDirty("SecCodigo") )
      {
         gxTv_SdtSeccion_N = (byte)(0) ;
         gxTv_SdtSeccion_Seccodigo = sdt.getgxTv_SdtSeccion_Seccodigo() ;
      }
      if ( sdt.IsDirty("SecDescrip") )
      {
         gxTv_SdtSeccion_N = (byte)(0) ;
         gxTv_SdtSeccion_Secdescrip = sdt.getgxTv_SdtSeccion_Secdescrip() ;
      }
      if ( sdt.IsDirty("SecHabilitada") )
      {
         gxTv_SdtSeccion_N = (byte)(0) ;
         gxTv_SdtSeccion_Sechabilitada = sdt.getgxTv_SdtSeccion_Sechabilitada() ;
      }
      if ( sdt.IsDirty("SecDescripSinAc") )
      {
         gxTv_SdtSeccion_N = (byte)(0) ;
         gxTv_SdtSeccion_Secdescripsinac = sdt.getgxTv_SdtSeccion_Secdescripsinac() ;
      }
      if ( sdt.IsDirty("SecRelSec") )
      {
         gxTv_SdtSeccion_N = (byte)(0) ;
         gxTv_SdtSeccion_Secrelsec = sdt.getgxTv_SdtSeccion_Secrelsec() ;
      }
      if ( sdt.IsDirty("SecRelSecCli") )
      {
         gxTv_SdtSeccion_N = (byte)(0) ;
         gxTv_SdtSeccion_Secrelseccli = sdt.getgxTv_SdtSeccion_Secrelseccli() ;
      }
      if ( sdt.IsDirty("SecPadre") )
      {
         gxTv_SdtSeccion_N = (byte)(0) ;
         gxTv_SdtSeccion_Secpadre = sdt.getgxTv_SdtSeccion_Secpadre() ;
      }
      if ( sdt.IsDirty("SecRelRef") )
      {
         gxTv_SdtSeccion_N = (byte)(0) ;
         gxTv_SdtSeccion_Secrelref = sdt.getgxTv_SdtSeccion_Secrelref() ;
      }
      if ( sdt.IsDirty("SecOld") )
      {
         gxTv_SdtSeccion_N = (byte)(0) ;
         gxTv_SdtSeccion_Secold = sdt.getgxTv_SdtSeccion_Secold() ;
      }
      if ( sdt.IsDirty("SecApoOpc") )
      {
         gxTv_SdtSeccion_N = (byte)(0) ;
         gxTv_SdtSeccion_Secapoopc = sdt.getgxTv_SdtSeccion_Secapoopc() ;
      }
      if ( gxTv_SdtSeccion_Puestos != null )
      {
         GXBCLevelCollection<web.SdtSeccion_Puestos> newCollectionPuestos = sdt.getgxTv_SdtSeccion_Puestos();
         web.SdtSeccion_Puestos currItemPuestos;
         web.SdtSeccion_Puestos newItemPuestos;
         short idx = 1;
         while ( idx <= newCollectionPuestos.size() )
         {
            newItemPuestos = (web.SdtSeccion_Puestos)((web.SdtSeccion_Puestos)newCollectionPuestos.elementAt(-1+idx));
            currItemPuestos = (web.SdtSeccion_Puestos)gxTv_SdtSeccion_Puestos.getByKey(newItemPuestos.getgxTv_SdtSeccion_Puestos_Puestocodigo());
            if ( GXutil.strcmp(currItemPuestos.getgxTv_SdtSeccion_Puestos_Mode(), "UPD") == 0 )
            {
               currItemPuestos.updateDirties(newItemPuestos);
               if ( GXutil.strcmp(newItemPuestos.getgxTv_SdtSeccion_Puestos_Mode(), "DLT") == 0 )
               {
                  currItemPuestos.setgxTv_SdtSeccion_Puestos_Mode( "DLT" );
               }
               currItemPuestos.setgxTv_SdtSeccion_Puestos_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtSeccion_Puestos.add(newItemPuestos, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
   }

   public int getgxTv_SdtSeccion_Clicod( )
   {
      return gxTv_SdtSeccion_Clicod ;
   }

   public void setgxTv_SdtSeccion_Clicod( int value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      if ( gxTv_SdtSeccion_Clicod != value )
      {
         gxTv_SdtSeccion_Mode = "INS" ;
         this.setgxTv_SdtSeccion_Clicod_Z_SetNull( );
         this.setgxTv_SdtSeccion_Seccodigo_Z_SetNull( );
         this.setgxTv_SdtSeccion_Secdescrip_Z_SetNull( );
         this.setgxTv_SdtSeccion_Sechabilitada_Z_SetNull( );
         this.setgxTv_SdtSeccion_Secdescripsinac_Z_SetNull( );
         this.setgxTv_SdtSeccion_Secrelsec_Z_SetNull( );
         this.setgxTv_SdtSeccion_Secrelseccli_Z_SetNull( );
         this.setgxTv_SdtSeccion_Secpadre_Z_SetNull( );
         this.setgxTv_SdtSeccion_Secrelref_Z_SetNull( );
         this.setgxTv_SdtSeccion_Secapoopc_Z_SetNull( );
         if ( gxTv_SdtSeccion_Puestos != null )
         {
            GXBCLevelCollection<web.SdtSeccion_Puestos> collectionPuestos = gxTv_SdtSeccion_Puestos;
            web.SdtSeccion_Puestos currItemPuestos;
            short idx = 1;
            while ( idx <= collectionPuestos.size() )
            {
               currItemPuestos = (web.SdtSeccion_Puestos)((web.SdtSeccion_Puestos)collectionPuestos.elementAt(-1+idx));
               currItemPuestos.setgxTv_SdtSeccion_Puestos_Mode( "INS" );
               currItemPuestos.setgxTv_SdtSeccion_Puestos_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Clicod");
      gxTv_SdtSeccion_Clicod = value ;
   }

   public String getgxTv_SdtSeccion_Seccodigo( )
   {
      return gxTv_SdtSeccion_Seccodigo ;
   }

   public void setgxTv_SdtSeccion_Seccodigo( String value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      if ( GXutil.strcmp(gxTv_SdtSeccion_Seccodigo, value) != 0 )
      {
         gxTv_SdtSeccion_Mode = "INS" ;
         this.setgxTv_SdtSeccion_Clicod_Z_SetNull( );
         this.setgxTv_SdtSeccion_Seccodigo_Z_SetNull( );
         this.setgxTv_SdtSeccion_Secdescrip_Z_SetNull( );
         this.setgxTv_SdtSeccion_Sechabilitada_Z_SetNull( );
         this.setgxTv_SdtSeccion_Secdescripsinac_Z_SetNull( );
         this.setgxTv_SdtSeccion_Secrelsec_Z_SetNull( );
         this.setgxTv_SdtSeccion_Secrelseccli_Z_SetNull( );
         this.setgxTv_SdtSeccion_Secpadre_Z_SetNull( );
         this.setgxTv_SdtSeccion_Secrelref_Z_SetNull( );
         this.setgxTv_SdtSeccion_Secapoopc_Z_SetNull( );
         if ( gxTv_SdtSeccion_Puestos != null )
         {
            GXBCLevelCollection<web.SdtSeccion_Puestos> collectionPuestos = gxTv_SdtSeccion_Puestos;
            web.SdtSeccion_Puestos currItemPuestos;
            short idx = 1;
            while ( idx <= collectionPuestos.size() )
            {
               currItemPuestos = (web.SdtSeccion_Puestos)((web.SdtSeccion_Puestos)collectionPuestos.elementAt(-1+idx));
               currItemPuestos.setgxTv_SdtSeccion_Puestos_Mode( "INS" );
               currItemPuestos.setgxTv_SdtSeccion_Puestos_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Seccodigo");
      gxTv_SdtSeccion_Seccodigo = value ;
   }

   public String getgxTv_SdtSeccion_Secdescrip( )
   {
      return gxTv_SdtSeccion_Secdescrip ;
   }

   public void setgxTv_SdtSeccion_Secdescrip( String value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      SetDirty("Secdescrip");
      gxTv_SdtSeccion_Secdescrip = value ;
   }

   public boolean getgxTv_SdtSeccion_Sechabilitada( )
   {
      return gxTv_SdtSeccion_Sechabilitada ;
   }

   public void setgxTv_SdtSeccion_Sechabilitada( boolean value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      SetDirty("Sechabilitada");
      gxTv_SdtSeccion_Sechabilitada = value ;
   }

   public String getgxTv_SdtSeccion_Secdescripsinac( )
   {
      return gxTv_SdtSeccion_Secdescripsinac ;
   }

   public void setgxTv_SdtSeccion_Secdescripsinac( String value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      SetDirty("Secdescripsinac");
      gxTv_SdtSeccion_Secdescripsinac = value ;
   }

   public int getgxTv_SdtSeccion_Secrelsec( )
   {
      return gxTv_SdtSeccion_Secrelsec ;
   }

   public void setgxTv_SdtSeccion_Secrelsec( int value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      SetDirty("Secrelsec");
      gxTv_SdtSeccion_Secrelsec = value ;
   }

   public int getgxTv_SdtSeccion_Secrelseccli( )
   {
      return gxTv_SdtSeccion_Secrelseccli ;
   }

   public void setgxTv_SdtSeccion_Secrelseccli( int value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      SetDirty("Secrelseccli");
      gxTv_SdtSeccion_Secrelseccli = value ;
   }

   public String getgxTv_SdtSeccion_Secpadre( )
   {
      return gxTv_SdtSeccion_Secpadre ;
   }

   public void setgxTv_SdtSeccion_Secpadre( String value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      SetDirty("Secpadre");
      gxTv_SdtSeccion_Secpadre = value ;
   }

   public String getgxTv_SdtSeccion_Secrelref( )
   {
      return gxTv_SdtSeccion_Secrelref ;
   }

   public void setgxTv_SdtSeccion_Secrelref( String value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      SetDirty("Secrelref");
      gxTv_SdtSeccion_Secrelref = value ;
   }

   public String getgxTv_SdtSeccion_Secold( )
   {
      return gxTv_SdtSeccion_Secold ;
   }

   public void setgxTv_SdtSeccion_Secold( String value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      SetDirty("Secold");
      gxTv_SdtSeccion_Secold = value ;
   }

   public boolean getgxTv_SdtSeccion_Secapoopc( )
   {
      return gxTv_SdtSeccion_Secapoopc ;
   }

   public void setgxTv_SdtSeccion_Secapoopc( boolean value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      SetDirty("Secapoopc");
      gxTv_SdtSeccion_Secapoopc = value ;
   }

   public GXBCLevelCollection<web.SdtSeccion_Puestos> getgxTv_SdtSeccion_Puestos( )
   {
      if ( gxTv_SdtSeccion_Puestos == null )
      {
         gxTv_SdtSeccion_Puestos = new GXBCLevelCollection<web.SdtSeccion_Puestos>(web.SdtSeccion_Puestos.class, "Seccion.Puestos", "PayDay", remoteHandle);
      }
      gxTv_SdtSeccion_N = (byte)(0) ;
      return gxTv_SdtSeccion_Puestos ;
   }

   public void setgxTv_SdtSeccion_Puestos( GXBCLevelCollection<web.SdtSeccion_Puestos> value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      SetDirty("Puestos");
      gxTv_SdtSeccion_Puestos = value ;
   }

   public void setgxTv_SdtSeccion_Puestos_SetNull( )
   {
      gxTv_SdtSeccion_Puestos = null ;
      SetDirty("Puestos");
   }

   public boolean getgxTv_SdtSeccion_Puestos_IsNull( )
   {
      if ( gxTv_SdtSeccion_Puestos == null )
      {
         return true ;
      }
      return false ;
   }

   public String getgxTv_SdtSeccion_Mode( )
   {
      return gxTv_SdtSeccion_Mode ;
   }

   public void setgxTv_SdtSeccion_Mode( String value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtSeccion_Mode = value ;
   }

   public void setgxTv_SdtSeccion_Mode_SetNull( )
   {
      gxTv_SdtSeccion_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtSeccion_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtSeccion_Initialized( )
   {
      return gxTv_SdtSeccion_Initialized ;
   }

   public void setgxTv_SdtSeccion_Initialized( short value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtSeccion_Initialized = value ;
   }

   public void setgxTv_SdtSeccion_Initialized_SetNull( )
   {
      gxTv_SdtSeccion_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtSeccion_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtSeccion_Clicod_Z( )
   {
      return gxTv_SdtSeccion_Clicod_Z ;
   }

   public void setgxTv_SdtSeccion_Clicod_Z( int value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_SdtSeccion_Clicod_Z = value ;
   }

   public void setgxTv_SdtSeccion_Clicod_Z_SetNull( )
   {
      gxTv_SdtSeccion_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_SdtSeccion_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSeccion_Seccodigo_Z( )
   {
      return gxTv_SdtSeccion_Seccodigo_Z ;
   }

   public void setgxTv_SdtSeccion_Seccodigo_Z( String value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      SetDirty("Seccodigo_Z");
      gxTv_SdtSeccion_Seccodigo_Z = value ;
   }

   public void setgxTv_SdtSeccion_Seccodigo_Z_SetNull( )
   {
      gxTv_SdtSeccion_Seccodigo_Z = "" ;
      SetDirty("Seccodigo_Z");
   }

   public boolean getgxTv_SdtSeccion_Seccodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSeccion_Secdescrip_Z( )
   {
      return gxTv_SdtSeccion_Secdescrip_Z ;
   }

   public void setgxTv_SdtSeccion_Secdescrip_Z( String value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      SetDirty("Secdescrip_Z");
      gxTv_SdtSeccion_Secdescrip_Z = value ;
   }

   public void setgxTv_SdtSeccion_Secdescrip_Z_SetNull( )
   {
      gxTv_SdtSeccion_Secdescrip_Z = "" ;
      SetDirty("Secdescrip_Z");
   }

   public boolean getgxTv_SdtSeccion_Secdescrip_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtSeccion_Sechabilitada_Z( )
   {
      return gxTv_SdtSeccion_Sechabilitada_Z ;
   }

   public void setgxTv_SdtSeccion_Sechabilitada_Z( boolean value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      SetDirty("Sechabilitada_Z");
      gxTv_SdtSeccion_Sechabilitada_Z = value ;
   }

   public void setgxTv_SdtSeccion_Sechabilitada_Z_SetNull( )
   {
      gxTv_SdtSeccion_Sechabilitada_Z = false ;
      SetDirty("Sechabilitada_Z");
   }

   public boolean getgxTv_SdtSeccion_Sechabilitada_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSeccion_Secdescripsinac_Z( )
   {
      return gxTv_SdtSeccion_Secdescripsinac_Z ;
   }

   public void setgxTv_SdtSeccion_Secdescripsinac_Z( String value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      SetDirty("Secdescripsinac_Z");
      gxTv_SdtSeccion_Secdescripsinac_Z = value ;
   }

   public void setgxTv_SdtSeccion_Secdescripsinac_Z_SetNull( )
   {
      gxTv_SdtSeccion_Secdescripsinac_Z = "" ;
      SetDirty("Secdescripsinac_Z");
   }

   public boolean getgxTv_SdtSeccion_Secdescripsinac_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtSeccion_Secrelsec_Z( )
   {
      return gxTv_SdtSeccion_Secrelsec_Z ;
   }

   public void setgxTv_SdtSeccion_Secrelsec_Z( int value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      SetDirty("Secrelsec_Z");
      gxTv_SdtSeccion_Secrelsec_Z = value ;
   }

   public void setgxTv_SdtSeccion_Secrelsec_Z_SetNull( )
   {
      gxTv_SdtSeccion_Secrelsec_Z = 0 ;
      SetDirty("Secrelsec_Z");
   }

   public boolean getgxTv_SdtSeccion_Secrelsec_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtSeccion_Secrelseccli_Z( )
   {
      return gxTv_SdtSeccion_Secrelseccli_Z ;
   }

   public void setgxTv_SdtSeccion_Secrelseccli_Z( int value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      SetDirty("Secrelseccli_Z");
      gxTv_SdtSeccion_Secrelseccli_Z = value ;
   }

   public void setgxTv_SdtSeccion_Secrelseccli_Z_SetNull( )
   {
      gxTv_SdtSeccion_Secrelseccli_Z = 0 ;
      SetDirty("Secrelseccli_Z");
   }

   public boolean getgxTv_SdtSeccion_Secrelseccli_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSeccion_Secpadre_Z( )
   {
      return gxTv_SdtSeccion_Secpadre_Z ;
   }

   public void setgxTv_SdtSeccion_Secpadre_Z( String value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      SetDirty("Secpadre_Z");
      gxTv_SdtSeccion_Secpadre_Z = value ;
   }

   public void setgxTv_SdtSeccion_Secpadre_Z_SetNull( )
   {
      gxTv_SdtSeccion_Secpadre_Z = "" ;
      SetDirty("Secpadre_Z");
   }

   public boolean getgxTv_SdtSeccion_Secpadre_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSeccion_Secrelref_Z( )
   {
      return gxTv_SdtSeccion_Secrelref_Z ;
   }

   public void setgxTv_SdtSeccion_Secrelref_Z( String value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      SetDirty("Secrelref_Z");
      gxTv_SdtSeccion_Secrelref_Z = value ;
   }

   public void setgxTv_SdtSeccion_Secrelref_Z_SetNull( )
   {
      gxTv_SdtSeccion_Secrelref_Z = "" ;
      SetDirty("Secrelref_Z");
   }

   public boolean getgxTv_SdtSeccion_Secrelref_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtSeccion_Secapoopc_Z( )
   {
      return gxTv_SdtSeccion_Secapoopc_Z ;
   }

   public void setgxTv_SdtSeccion_Secapoopc_Z( boolean value )
   {
      gxTv_SdtSeccion_N = (byte)(0) ;
      SetDirty("Secapoopc_Z");
      gxTv_SdtSeccion_Secapoopc_Z = value ;
   }

   public void setgxTv_SdtSeccion_Secapoopc_Z_SetNull( )
   {
      gxTv_SdtSeccion_Secapoopc_Z = false ;
      SetDirty("Secapoopc_Z");
   }

   public boolean getgxTv_SdtSeccion_Secapoopc_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.seccion_bc obj;
      obj = new web.seccion_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtSeccion_N = (byte)(1) ;
      gxTv_SdtSeccion_Seccodigo = "" ;
      gxTv_SdtSeccion_Secdescrip = "" ;
      gxTv_SdtSeccion_Secdescripsinac = "" ;
      gxTv_SdtSeccion_Secpadre = "" ;
      gxTv_SdtSeccion_Secrelref = "" ;
      gxTv_SdtSeccion_Secold = "" ;
      gxTv_SdtSeccion_Mode = "" ;
      gxTv_SdtSeccion_Seccodigo_Z = "" ;
      gxTv_SdtSeccion_Secdescrip_Z = "" ;
      gxTv_SdtSeccion_Secdescripsinac_Z = "" ;
      gxTv_SdtSeccion_Secpadre_Z = "" ;
      gxTv_SdtSeccion_Secrelref_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSeccion_N ;
   }

   public web.SdtSeccion Clone( )
   {
      web.SdtSeccion sdt;
      web.seccion_bc obj;
      sdt = (web.SdtSeccion)(clone()) ;
      obj = (web.seccion_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtSeccion struct )
   {
      setgxTv_SdtSeccion_Clicod(struct.getClicod());
      setgxTv_SdtSeccion_Seccodigo(struct.getSeccodigo());
      setgxTv_SdtSeccion_Secdescrip(struct.getSecdescrip());
      setgxTv_SdtSeccion_Sechabilitada(struct.getSechabilitada());
      setgxTv_SdtSeccion_Secdescripsinac(struct.getSecdescripsinac());
      setgxTv_SdtSeccion_Secrelsec(struct.getSecrelsec());
      setgxTv_SdtSeccion_Secrelseccli(struct.getSecrelseccli());
      setgxTv_SdtSeccion_Secpadre(struct.getSecpadre());
      setgxTv_SdtSeccion_Secrelref(struct.getSecrelref());
      setgxTv_SdtSeccion_Secold(struct.getSecold());
      setgxTv_SdtSeccion_Secapoopc(struct.getSecapoopc());
      GXBCLevelCollection<web.SdtSeccion_Puestos> gxTv_SdtSeccion_Puestos_aux = new GXBCLevelCollection<web.SdtSeccion_Puestos>(web.SdtSeccion_Puestos.class, "Seccion.Puestos", "PayDay", remoteHandle);
      Vector<web.StructSdtSeccion_Puestos> gxTv_SdtSeccion_Puestos_aux1 = struct.getPuestos();
      if (gxTv_SdtSeccion_Puestos_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtSeccion_Puestos_aux1.size(); i++)
         {
            gxTv_SdtSeccion_Puestos_aux.add(new web.SdtSeccion_Puestos(remoteHandle, gxTv_SdtSeccion_Puestos_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtSeccion_Puestos(gxTv_SdtSeccion_Puestos_aux);
      setgxTv_SdtSeccion_Mode(struct.getMode());
      setgxTv_SdtSeccion_Initialized(struct.getInitialized());
      setgxTv_SdtSeccion_Clicod_Z(struct.getClicod_Z());
      setgxTv_SdtSeccion_Seccodigo_Z(struct.getSeccodigo_Z());
      setgxTv_SdtSeccion_Secdescrip_Z(struct.getSecdescrip_Z());
      setgxTv_SdtSeccion_Sechabilitada_Z(struct.getSechabilitada_Z());
      setgxTv_SdtSeccion_Secdescripsinac_Z(struct.getSecdescripsinac_Z());
      setgxTv_SdtSeccion_Secrelsec_Z(struct.getSecrelsec_Z());
      setgxTv_SdtSeccion_Secrelseccli_Z(struct.getSecrelseccli_Z());
      setgxTv_SdtSeccion_Secpadre_Z(struct.getSecpadre_Z());
      setgxTv_SdtSeccion_Secrelref_Z(struct.getSecrelref_Z());
      setgxTv_SdtSeccion_Secapoopc_Z(struct.getSecapoopc_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtSeccion getStruct( )
   {
      web.StructSdtSeccion struct = new web.StructSdtSeccion ();
      struct.setClicod(getgxTv_SdtSeccion_Clicod());
      struct.setSeccodigo(getgxTv_SdtSeccion_Seccodigo());
      struct.setSecdescrip(getgxTv_SdtSeccion_Secdescrip());
      struct.setSechabilitada(getgxTv_SdtSeccion_Sechabilitada());
      struct.setSecdescripsinac(getgxTv_SdtSeccion_Secdescripsinac());
      struct.setSecrelsec(getgxTv_SdtSeccion_Secrelsec());
      struct.setSecrelseccli(getgxTv_SdtSeccion_Secrelseccli());
      struct.setSecpadre(getgxTv_SdtSeccion_Secpadre());
      struct.setSecrelref(getgxTv_SdtSeccion_Secrelref());
      struct.setSecold(getgxTv_SdtSeccion_Secold());
      struct.setSecapoopc(getgxTv_SdtSeccion_Secapoopc());
      struct.setPuestos(getgxTv_SdtSeccion_Puestos().getStruct());
      struct.setMode(getgxTv_SdtSeccion_Mode());
      struct.setInitialized(getgxTv_SdtSeccion_Initialized());
      struct.setClicod_Z(getgxTv_SdtSeccion_Clicod_Z());
      struct.setSeccodigo_Z(getgxTv_SdtSeccion_Seccodigo_Z());
      struct.setSecdescrip_Z(getgxTv_SdtSeccion_Secdescrip_Z());
      struct.setSechabilitada_Z(getgxTv_SdtSeccion_Sechabilitada_Z());
      struct.setSecdescripsinac_Z(getgxTv_SdtSeccion_Secdescripsinac_Z());
      struct.setSecrelsec_Z(getgxTv_SdtSeccion_Secrelsec_Z());
      struct.setSecrelseccli_Z(getgxTv_SdtSeccion_Secrelseccli_Z());
      struct.setSecpadre_Z(getgxTv_SdtSeccion_Secpadre_Z());
      struct.setSecrelref_Z(getgxTv_SdtSeccion_Secrelref_Z());
      struct.setSecapoopc_Z(getgxTv_SdtSeccion_Secapoopc_Z());
      return struct ;
   }

   private byte gxTv_SdtSeccion_N ;
   private short gxTv_SdtSeccion_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtSeccion_Clicod ;
   private int gxTv_SdtSeccion_Secrelsec ;
   private int gxTv_SdtSeccion_Secrelseccli ;
   private int gxTv_SdtSeccion_Clicod_Z ;
   private int gxTv_SdtSeccion_Secrelsec_Z ;
   private int gxTv_SdtSeccion_Secrelseccli_Z ;
   private String gxTv_SdtSeccion_Seccodigo ;
   private String gxTv_SdtSeccion_Secpadre ;
   private String gxTv_SdtSeccion_Mode ;
   private String gxTv_SdtSeccion_Seccodigo_Z ;
   private String gxTv_SdtSeccion_Secpadre_Z ;
   private String sTagName ;
   private boolean gxTv_SdtSeccion_Sechabilitada ;
   private boolean gxTv_SdtSeccion_Secapoopc ;
   private boolean gxTv_SdtSeccion_Sechabilitada_Z ;
   private boolean gxTv_SdtSeccion_Secapoopc_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtSeccion_Secold ;
   private String gxTv_SdtSeccion_Secdescrip ;
   private String gxTv_SdtSeccion_Secdescripsinac ;
   private String gxTv_SdtSeccion_Secrelref ;
   private String gxTv_SdtSeccion_Secdescrip_Z ;
   private String gxTv_SdtSeccion_Secdescripsinac_Z ;
   private String gxTv_SdtSeccion_Secrelref_Z ;
   private GXBCLevelCollection<web.SdtSeccion_Puestos> gxTv_SdtSeccion_Puestos_aux ;
   private GXBCLevelCollection<web.SdtSeccion_Puestos> gxTv_SdtSeccion_Puestos=null ;
}

