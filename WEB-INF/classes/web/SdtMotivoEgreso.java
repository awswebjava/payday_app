package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtMotivoEgreso extends GxSilentTrnSdt
{
   public SdtMotivoEgreso( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtMotivoEgreso.class));
   }

   public SdtMotivoEgreso( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle, context, "SdtMotivoEgreso");
      initialize( remoteHandle) ;
   }

   public SdtMotivoEgreso( int remoteHandle ,
                           StructSdtMotivoEgreso struct )
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
                     String AV11MegCodigo )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV3CliCod),AV11MegCodigo});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CliCod", int.class}, new Object[]{"MegCodigo", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "MotivoEgreso");
      metadata.set("BT", "MotivoEgreso");
      metadata.set("PK", "[ \"CliCod\",\"MegCodigo\" ]");
      metadata.set("PKAssigned", "[ \"CliCod\" ]");
      metadata.set("Levels", "[ \"RevistaAfip\" ]");
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
               gxTv_SdtMotivoEgreso_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegCodigo") )
            {
               gxTv_SdtMotivoEgreso_Megcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegDescrip") )
            {
               gxTv_SdtMotivoEgreso_Megdescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegHabilitado") )
            {
               gxTv_SdtMotivoEgreso_Meghabilitado = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegRes551") )
            {
               gxTv_SdtMotivoEgreso_Megres551 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegRelSec") )
            {
               gxTv_SdtMotivoEgreso_Megrelsec = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegRelSecCli") )
            {
               gxTv_SdtMotivoEgreso_Megrelseccli = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegPadre") )
            {
               gxTv_SdtMotivoEgreso_Megpadre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegRelRef") )
            {
               gxTv_SdtMotivoEgreso_Megrelref = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegOld") )
            {
               gxTv_SdtMotivoEgreso_Megold = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RevistaAfip") )
            {
               if ( gxTv_SdtMotivoEgreso_Revistaafip == null )
               {
                  gxTv_SdtMotivoEgreso_Revistaafip = new GXBCLevelCollection<web.SdtMotivoEgreso_RevistaAfip>(web.SdtMotivoEgreso_RevistaAfip.class, "MotivoEgreso.RevistaAfip", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtMotivoEgreso_Revistaafip.readxml(oReader, "RevistaAfip") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "RevistaAfip") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtMotivoEgreso_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtMotivoEgreso_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_SdtMotivoEgreso_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegCodigo_Z") )
            {
               gxTv_SdtMotivoEgreso_Megcodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegDescrip_Z") )
            {
               gxTv_SdtMotivoEgreso_Megdescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegHabilitado_Z") )
            {
               gxTv_SdtMotivoEgreso_Meghabilitado_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegRes551_Z") )
            {
               gxTv_SdtMotivoEgreso_Megres551_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegRelSec_Z") )
            {
               gxTv_SdtMotivoEgreso_Megrelsec_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegRelSecCli_Z") )
            {
               gxTv_SdtMotivoEgreso_Megrelseccli_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegPadre_Z") )
            {
               gxTv_SdtMotivoEgreso_Megpadre_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegRelRef_Z") )
            {
               gxTv_SdtMotivoEgreso_Megrelref_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegRes551_N") )
            {
               gxTv_SdtMotivoEgreso_Megres551_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "MotivoEgreso" ;
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
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_SdtMotivoEgreso_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MegCodigo", gxTv_SdtMotivoEgreso_Megcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MegDescrip", gxTv_SdtMotivoEgreso_Megdescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MegHabilitado", GXutil.booltostr( gxTv_SdtMotivoEgreso_Meghabilitado));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MegRes551", gxTv_SdtMotivoEgreso_Megres551);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MegRelSec", GXutil.trim( GXutil.str( gxTv_SdtMotivoEgreso_Megrelsec, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MegRelSecCli", GXutil.trim( GXutil.str( gxTv_SdtMotivoEgreso_Megrelseccli, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MegPadre", gxTv_SdtMotivoEgreso_Megpadre);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MegRelRef", gxTv_SdtMotivoEgreso_Megrelref);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MegOld", gxTv_SdtMotivoEgreso_Megold);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_SdtMotivoEgreso_Revistaafip != null )
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
         gxTv_SdtMotivoEgreso_Revistaafip.writexml(oWriter, "RevistaAfip", sNameSpace1, sIncludeState);
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtMotivoEgreso_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtMotivoEgreso_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_SdtMotivoEgreso_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MegCodigo_Z", gxTv_SdtMotivoEgreso_Megcodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MegDescrip_Z", gxTv_SdtMotivoEgreso_Megdescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MegHabilitado_Z", GXutil.booltostr( gxTv_SdtMotivoEgreso_Meghabilitado_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MegRes551_Z", gxTv_SdtMotivoEgreso_Megres551_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MegRelSec_Z", GXutil.trim( GXutil.str( gxTv_SdtMotivoEgreso_Megrelsec_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MegRelSecCli_Z", GXutil.trim( GXutil.str( gxTv_SdtMotivoEgreso_Megrelseccli_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MegPadre_Z", gxTv_SdtMotivoEgreso_Megpadre_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MegRelRef_Z", gxTv_SdtMotivoEgreso_Megrelref_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MegRes551_N", GXutil.trim( GXutil.str( gxTv_SdtMotivoEgreso_Megres551_N, 1, 0)));
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
      AddObjectProperty("CliCod", gxTv_SdtMotivoEgreso_Clicod, false, includeNonInitialized);
      AddObjectProperty("MegCodigo", gxTv_SdtMotivoEgreso_Megcodigo, false, includeNonInitialized);
      AddObjectProperty("MegDescrip", gxTv_SdtMotivoEgreso_Megdescrip, false, includeNonInitialized);
      AddObjectProperty("MegHabilitado", gxTv_SdtMotivoEgreso_Meghabilitado, false, includeNonInitialized);
      AddObjectProperty("MegRes551", gxTv_SdtMotivoEgreso_Megres551, false, includeNonInitialized);
      AddObjectProperty("MegRes551_N", gxTv_SdtMotivoEgreso_Megres551_N, false, includeNonInitialized);
      AddObjectProperty("MegRelSec", gxTv_SdtMotivoEgreso_Megrelsec, false, includeNonInitialized);
      AddObjectProperty("MegRelSecCli", gxTv_SdtMotivoEgreso_Megrelseccli, false, includeNonInitialized);
      AddObjectProperty("MegPadre", gxTv_SdtMotivoEgreso_Megpadre, false, includeNonInitialized);
      AddObjectProperty("MegRelRef", gxTv_SdtMotivoEgreso_Megrelref, false, includeNonInitialized);
      AddObjectProperty("MegOld", gxTv_SdtMotivoEgreso_Megold, false, includeNonInitialized);
      if ( gxTv_SdtMotivoEgreso_Revistaafip != null )
      {
         AddObjectProperty("RevistaAfip", gxTv_SdtMotivoEgreso_Revistaafip, includeState, includeNonInitialized);
      }
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtMotivoEgreso_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtMotivoEgreso_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_SdtMotivoEgreso_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("MegCodigo_Z", gxTv_SdtMotivoEgreso_Megcodigo_Z, false, includeNonInitialized);
         AddObjectProperty("MegDescrip_Z", gxTv_SdtMotivoEgreso_Megdescrip_Z, false, includeNonInitialized);
         AddObjectProperty("MegHabilitado_Z", gxTv_SdtMotivoEgreso_Meghabilitado_Z, false, includeNonInitialized);
         AddObjectProperty("MegRes551_Z", gxTv_SdtMotivoEgreso_Megres551_Z, false, includeNonInitialized);
         AddObjectProperty("MegRelSec_Z", gxTv_SdtMotivoEgreso_Megrelsec_Z, false, includeNonInitialized);
         AddObjectProperty("MegRelSecCli_Z", gxTv_SdtMotivoEgreso_Megrelseccli_Z, false, includeNonInitialized);
         AddObjectProperty("MegPadre_Z", gxTv_SdtMotivoEgreso_Megpadre_Z, false, includeNonInitialized);
         AddObjectProperty("MegRelRef_Z", gxTv_SdtMotivoEgreso_Megrelref_Z, false, includeNonInitialized);
         AddObjectProperty("MegRes551_N", gxTv_SdtMotivoEgreso_Megres551_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtMotivoEgreso sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_SdtMotivoEgreso_N = (byte)(0) ;
         gxTv_SdtMotivoEgreso_Clicod = sdt.getgxTv_SdtMotivoEgreso_Clicod() ;
      }
      if ( sdt.IsDirty("MegCodigo") )
      {
         gxTv_SdtMotivoEgreso_N = (byte)(0) ;
         gxTv_SdtMotivoEgreso_Megcodigo = sdt.getgxTv_SdtMotivoEgreso_Megcodigo() ;
      }
      if ( sdt.IsDirty("MegDescrip") )
      {
         gxTv_SdtMotivoEgreso_N = (byte)(0) ;
         gxTv_SdtMotivoEgreso_Megdescrip = sdt.getgxTv_SdtMotivoEgreso_Megdescrip() ;
      }
      if ( sdt.IsDirty("MegHabilitado") )
      {
         gxTv_SdtMotivoEgreso_N = (byte)(0) ;
         gxTv_SdtMotivoEgreso_Meghabilitado = sdt.getgxTv_SdtMotivoEgreso_Meghabilitado() ;
      }
      if ( sdt.IsDirty("MegRes551") )
      {
         gxTv_SdtMotivoEgreso_Megres551_N = sdt.getgxTv_SdtMotivoEgreso_Megres551_N() ;
         gxTv_SdtMotivoEgreso_N = (byte)(0) ;
         gxTv_SdtMotivoEgreso_Megres551 = sdt.getgxTv_SdtMotivoEgreso_Megres551() ;
      }
      if ( sdt.IsDirty("MegRelSec") )
      {
         gxTv_SdtMotivoEgreso_N = (byte)(0) ;
         gxTv_SdtMotivoEgreso_Megrelsec = sdt.getgxTv_SdtMotivoEgreso_Megrelsec() ;
      }
      if ( sdt.IsDirty("MegRelSecCli") )
      {
         gxTv_SdtMotivoEgreso_N = (byte)(0) ;
         gxTv_SdtMotivoEgreso_Megrelseccli = sdt.getgxTv_SdtMotivoEgreso_Megrelseccli() ;
      }
      if ( sdt.IsDirty("MegPadre") )
      {
         gxTv_SdtMotivoEgreso_N = (byte)(0) ;
         gxTv_SdtMotivoEgreso_Megpadre = sdt.getgxTv_SdtMotivoEgreso_Megpadre() ;
      }
      if ( sdt.IsDirty("MegRelRef") )
      {
         gxTv_SdtMotivoEgreso_N = (byte)(0) ;
         gxTv_SdtMotivoEgreso_Megrelref = sdt.getgxTv_SdtMotivoEgreso_Megrelref() ;
      }
      if ( sdt.IsDirty("MegOld") )
      {
         gxTv_SdtMotivoEgreso_N = (byte)(0) ;
         gxTv_SdtMotivoEgreso_Megold = sdt.getgxTv_SdtMotivoEgreso_Megold() ;
      }
      if ( gxTv_SdtMotivoEgreso_Revistaafip != null )
      {
         GXBCLevelCollection<web.SdtMotivoEgreso_RevistaAfip> newCollectionRevistaafip = sdt.getgxTv_SdtMotivoEgreso_Revistaafip();
         web.SdtMotivoEgreso_RevistaAfip currItemRevistaafip;
         web.SdtMotivoEgreso_RevistaAfip newItemRevistaafip;
         short idx = 1;
         while ( idx <= newCollectionRevistaafip.size() )
         {
            newItemRevistaafip = (web.SdtMotivoEgreso_RevistaAfip)((web.SdtMotivoEgreso_RevistaAfip)newCollectionRevistaafip.elementAt(-1+idx));
            currItemRevistaafip = (web.SdtMotivoEgreso_RevistaAfip)gxTv_SdtMotivoEgreso_Revistaafip.getByKey(newItemRevistaafip.getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista());
            if ( GXutil.strcmp(currItemRevistaafip.getgxTv_SdtMotivoEgreso_RevistaAfip_Mode(), "UPD") == 0 )
            {
               currItemRevistaafip.updateDirties(newItemRevistaafip);
               if ( GXutil.strcmp(newItemRevistaafip.getgxTv_SdtMotivoEgreso_RevistaAfip_Mode(), "DLT") == 0 )
               {
                  currItemRevistaafip.setgxTv_SdtMotivoEgreso_RevistaAfip_Mode( "DLT" );
               }
               currItemRevistaafip.setgxTv_SdtMotivoEgreso_RevistaAfip_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtMotivoEgreso_Revistaafip.add(newItemRevistaafip, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
   }

   public int getgxTv_SdtMotivoEgreso_Clicod( )
   {
      return gxTv_SdtMotivoEgreso_Clicod ;
   }

   public void setgxTv_SdtMotivoEgreso_Clicod( int value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      if ( gxTv_SdtMotivoEgreso_Clicod != value )
      {
         gxTv_SdtMotivoEgreso_Mode = "INS" ;
         this.setgxTv_SdtMotivoEgreso_Clicod_Z_SetNull( );
         this.setgxTv_SdtMotivoEgreso_Megcodigo_Z_SetNull( );
         this.setgxTv_SdtMotivoEgreso_Megdescrip_Z_SetNull( );
         this.setgxTv_SdtMotivoEgreso_Meghabilitado_Z_SetNull( );
         this.setgxTv_SdtMotivoEgreso_Megres551_Z_SetNull( );
         this.setgxTv_SdtMotivoEgreso_Megrelsec_Z_SetNull( );
         this.setgxTv_SdtMotivoEgreso_Megrelseccli_Z_SetNull( );
         this.setgxTv_SdtMotivoEgreso_Megpadre_Z_SetNull( );
         this.setgxTv_SdtMotivoEgreso_Megrelref_Z_SetNull( );
         if ( gxTv_SdtMotivoEgreso_Revistaafip != null )
         {
            GXBCLevelCollection<web.SdtMotivoEgreso_RevistaAfip> collectionRevistaafip = gxTv_SdtMotivoEgreso_Revistaafip;
            web.SdtMotivoEgreso_RevistaAfip currItemRevistaafip;
            short idx = 1;
            while ( idx <= collectionRevistaafip.size() )
            {
               currItemRevistaafip = (web.SdtMotivoEgreso_RevistaAfip)((web.SdtMotivoEgreso_RevistaAfip)collectionRevistaafip.elementAt(-1+idx));
               currItemRevistaafip.setgxTv_SdtMotivoEgreso_RevistaAfip_Mode( "INS" );
               currItemRevistaafip.setgxTv_SdtMotivoEgreso_RevistaAfip_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Clicod");
      gxTv_SdtMotivoEgreso_Clicod = value ;
   }

   public String getgxTv_SdtMotivoEgreso_Megcodigo( )
   {
      return gxTv_SdtMotivoEgreso_Megcodigo ;
   }

   public void setgxTv_SdtMotivoEgreso_Megcodigo( String value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      if ( GXutil.strcmp(gxTv_SdtMotivoEgreso_Megcodigo, value) != 0 )
      {
         gxTv_SdtMotivoEgreso_Mode = "INS" ;
         this.setgxTv_SdtMotivoEgreso_Clicod_Z_SetNull( );
         this.setgxTv_SdtMotivoEgreso_Megcodigo_Z_SetNull( );
         this.setgxTv_SdtMotivoEgreso_Megdescrip_Z_SetNull( );
         this.setgxTv_SdtMotivoEgreso_Meghabilitado_Z_SetNull( );
         this.setgxTv_SdtMotivoEgreso_Megres551_Z_SetNull( );
         this.setgxTv_SdtMotivoEgreso_Megrelsec_Z_SetNull( );
         this.setgxTv_SdtMotivoEgreso_Megrelseccli_Z_SetNull( );
         this.setgxTv_SdtMotivoEgreso_Megpadre_Z_SetNull( );
         this.setgxTv_SdtMotivoEgreso_Megrelref_Z_SetNull( );
         if ( gxTv_SdtMotivoEgreso_Revistaafip != null )
         {
            GXBCLevelCollection<web.SdtMotivoEgreso_RevistaAfip> collectionRevistaafip = gxTv_SdtMotivoEgreso_Revistaafip;
            web.SdtMotivoEgreso_RevistaAfip currItemRevistaafip;
            short idx = 1;
            while ( idx <= collectionRevistaafip.size() )
            {
               currItemRevistaafip = (web.SdtMotivoEgreso_RevistaAfip)((web.SdtMotivoEgreso_RevistaAfip)collectionRevistaafip.elementAt(-1+idx));
               currItemRevistaafip.setgxTv_SdtMotivoEgreso_RevistaAfip_Mode( "INS" );
               currItemRevistaafip.setgxTv_SdtMotivoEgreso_RevistaAfip_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Megcodigo");
      gxTv_SdtMotivoEgreso_Megcodigo = value ;
   }

   public String getgxTv_SdtMotivoEgreso_Megdescrip( )
   {
      return gxTv_SdtMotivoEgreso_Megdescrip ;
   }

   public void setgxTv_SdtMotivoEgreso_Megdescrip( String value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      SetDirty("Megdescrip");
      gxTv_SdtMotivoEgreso_Megdescrip = value ;
   }

   public boolean getgxTv_SdtMotivoEgreso_Meghabilitado( )
   {
      return gxTv_SdtMotivoEgreso_Meghabilitado ;
   }

   public void setgxTv_SdtMotivoEgreso_Meghabilitado( boolean value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      SetDirty("Meghabilitado");
      gxTv_SdtMotivoEgreso_Meghabilitado = value ;
   }

   public String getgxTv_SdtMotivoEgreso_Megres551( )
   {
      return gxTv_SdtMotivoEgreso_Megres551 ;
   }

   public void setgxTv_SdtMotivoEgreso_Megres551( String value )
   {
      gxTv_SdtMotivoEgreso_Megres551_N = (byte)(0) ;
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      SetDirty("Megres551");
      gxTv_SdtMotivoEgreso_Megres551 = value ;
   }

   public void setgxTv_SdtMotivoEgreso_Megres551_SetNull( )
   {
      gxTv_SdtMotivoEgreso_Megres551_N = (byte)(1) ;
      gxTv_SdtMotivoEgreso_Megres551 = "" ;
      SetDirty("Megres551");
   }

   public boolean getgxTv_SdtMotivoEgreso_Megres551_IsNull( )
   {
      return (gxTv_SdtMotivoEgreso_Megres551_N==1) ;
   }

   public int getgxTv_SdtMotivoEgreso_Megrelsec( )
   {
      return gxTv_SdtMotivoEgreso_Megrelsec ;
   }

   public void setgxTv_SdtMotivoEgreso_Megrelsec( int value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      SetDirty("Megrelsec");
      gxTv_SdtMotivoEgreso_Megrelsec = value ;
   }

   public int getgxTv_SdtMotivoEgreso_Megrelseccli( )
   {
      return gxTv_SdtMotivoEgreso_Megrelseccli ;
   }

   public void setgxTv_SdtMotivoEgreso_Megrelseccli( int value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      SetDirty("Megrelseccli");
      gxTv_SdtMotivoEgreso_Megrelseccli = value ;
   }

   public String getgxTv_SdtMotivoEgreso_Megpadre( )
   {
      return gxTv_SdtMotivoEgreso_Megpadre ;
   }

   public void setgxTv_SdtMotivoEgreso_Megpadre( String value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      SetDirty("Megpadre");
      gxTv_SdtMotivoEgreso_Megpadre = value ;
   }

   public String getgxTv_SdtMotivoEgreso_Megrelref( )
   {
      return gxTv_SdtMotivoEgreso_Megrelref ;
   }

   public void setgxTv_SdtMotivoEgreso_Megrelref( String value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      SetDirty("Megrelref");
      gxTv_SdtMotivoEgreso_Megrelref = value ;
   }

   public String getgxTv_SdtMotivoEgreso_Megold( )
   {
      return gxTv_SdtMotivoEgreso_Megold ;
   }

   public void setgxTv_SdtMotivoEgreso_Megold( String value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      SetDirty("Megold");
      gxTv_SdtMotivoEgreso_Megold = value ;
   }

   public GXBCLevelCollection<web.SdtMotivoEgreso_RevistaAfip> getgxTv_SdtMotivoEgreso_Revistaafip( )
   {
      if ( gxTv_SdtMotivoEgreso_Revistaafip == null )
      {
         gxTv_SdtMotivoEgreso_Revistaafip = new GXBCLevelCollection<web.SdtMotivoEgreso_RevistaAfip>(web.SdtMotivoEgreso_RevistaAfip.class, "MotivoEgreso.RevistaAfip", "PayDay", remoteHandle);
      }
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      return gxTv_SdtMotivoEgreso_Revistaafip ;
   }

   public void setgxTv_SdtMotivoEgreso_Revistaafip( GXBCLevelCollection<web.SdtMotivoEgreso_RevistaAfip> value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      SetDirty("Revistaafip");
      gxTv_SdtMotivoEgreso_Revistaafip = value ;
   }

   public void setgxTv_SdtMotivoEgreso_Revistaafip_SetNull( )
   {
      gxTv_SdtMotivoEgreso_Revistaafip = null ;
      SetDirty("Revistaafip");
   }

   public boolean getgxTv_SdtMotivoEgreso_Revistaafip_IsNull( )
   {
      if ( gxTv_SdtMotivoEgreso_Revistaafip == null )
      {
         return true ;
      }
      return false ;
   }

   public String getgxTv_SdtMotivoEgreso_Mode( )
   {
      return gxTv_SdtMotivoEgreso_Mode ;
   }

   public void setgxTv_SdtMotivoEgreso_Mode( String value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtMotivoEgreso_Mode = value ;
   }

   public void setgxTv_SdtMotivoEgreso_Mode_SetNull( )
   {
      gxTv_SdtMotivoEgreso_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtMotivoEgreso_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtMotivoEgreso_Initialized( )
   {
      return gxTv_SdtMotivoEgreso_Initialized ;
   }

   public void setgxTv_SdtMotivoEgreso_Initialized( short value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtMotivoEgreso_Initialized = value ;
   }

   public void setgxTv_SdtMotivoEgreso_Initialized_SetNull( )
   {
      gxTv_SdtMotivoEgreso_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtMotivoEgreso_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtMotivoEgreso_Clicod_Z( )
   {
      return gxTv_SdtMotivoEgreso_Clicod_Z ;
   }

   public void setgxTv_SdtMotivoEgreso_Clicod_Z( int value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_SdtMotivoEgreso_Clicod_Z = value ;
   }

   public void setgxTv_SdtMotivoEgreso_Clicod_Z_SetNull( )
   {
      gxTv_SdtMotivoEgreso_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_SdtMotivoEgreso_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtMotivoEgreso_Megcodigo_Z( )
   {
      return gxTv_SdtMotivoEgreso_Megcodigo_Z ;
   }

   public void setgxTv_SdtMotivoEgreso_Megcodigo_Z( String value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      SetDirty("Megcodigo_Z");
      gxTv_SdtMotivoEgreso_Megcodigo_Z = value ;
   }

   public void setgxTv_SdtMotivoEgreso_Megcodigo_Z_SetNull( )
   {
      gxTv_SdtMotivoEgreso_Megcodigo_Z = "" ;
      SetDirty("Megcodigo_Z");
   }

   public boolean getgxTv_SdtMotivoEgreso_Megcodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtMotivoEgreso_Megdescrip_Z( )
   {
      return gxTv_SdtMotivoEgreso_Megdescrip_Z ;
   }

   public void setgxTv_SdtMotivoEgreso_Megdescrip_Z( String value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      SetDirty("Megdescrip_Z");
      gxTv_SdtMotivoEgreso_Megdescrip_Z = value ;
   }

   public void setgxTv_SdtMotivoEgreso_Megdescrip_Z_SetNull( )
   {
      gxTv_SdtMotivoEgreso_Megdescrip_Z = "" ;
      SetDirty("Megdescrip_Z");
   }

   public boolean getgxTv_SdtMotivoEgreso_Megdescrip_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtMotivoEgreso_Meghabilitado_Z( )
   {
      return gxTv_SdtMotivoEgreso_Meghabilitado_Z ;
   }

   public void setgxTv_SdtMotivoEgreso_Meghabilitado_Z( boolean value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      SetDirty("Meghabilitado_Z");
      gxTv_SdtMotivoEgreso_Meghabilitado_Z = value ;
   }

   public void setgxTv_SdtMotivoEgreso_Meghabilitado_Z_SetNull( )
   {
      gxTv_SdtMotivoEgreso_Meghabilitado_Z = false ;
      SetDirty("Meghabilitado_Z");
   }

   public boolean getgxTv_SdtMotivoEgreso_Meghabilitado_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtMotivoEgreso_Megres551_Z( )
   {
      return gxTv_SdtMotivoEgreso_Megres551_Z ;
   }

   public void setgxTv_SdtMotivoEgreso_Megres551_Z( String value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      SetDirty("Megres551_Z");
      gxTv_SdtMotivoEgreso_Megres551_Z = value ;
   }

   public void setgxTv_SdtMotivoEgreso_Megres551_Z_SetNull( )
   {
      gxTv_SdtMotivoEgreso_Megres551_Z = "" ;
      SetDirty("Megres551_Z");
   }

   public boolean getgxTv_SdtMotivoEgreso_Megres551_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtMotivoEgreso_Megrelsec_Z( )
   {
      return gxTv_SdtMotivoEgreso_Megrelsec_Z ;
   }

   public void setgxTv_SdtMotivoEgreso_Megrelsec_Z( int value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      SetDirty("Megrelsec_Z");
      gxTv_SdtMotivoEgreso_Megrelsec_Z = value ;
   }

   public void setgxTv_SdtMotivoEgreso_Megrelsec_Z_SetNull( )
   {
      gxTv_SdtMotivoEgreso_Megrelsec_Z = 0 ;
      SetDirty("Megrelsec_Z");
   }

   public boolean getgxTv_SdtMotivoEgreso_Megrelsec_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtMotivoEgreso_Megrelseccli_Z( )
   {
      return gxTv_SdtMotivoEgreso_Megrelseccli_Z ;
   }

   public void setgxTv_SdtMotivoEgreso_Megrelseccli_Z( int value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      SetDirty("Megrelseccli_Z");
      gxTv_SdtMotivoEgreso_Megrelseccli_Z = value ;
   }

   public void setgxTv_SdtMotivoEgreso_Megrelseccli_Z_SetNull( )
   {
      gxTv_SdtMotivoEgreso_Megrelseccli_Z = 0 ;
      SetDirty("Megrelseccli_Z");
   }

   public boolean getgxTv_SdtMotivoEgreso_Megrelseccli_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtMotivoEgreso_Megpadre_Z( )
   {
      return gxTv_SdtMotivoEgreso_Megpadre_Z ;
   }

   public void setgxTv_SdtMotivoEgreso_Megpadre_Z( String value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      SetDirty("Megpadre_Z");
      gxTv_SdtMotivoEgreso_Megpadre_Z = value ;
   }

   public void setgxTv_SdtMotivoEgreso_Megpadre_Z_SetNull( )
   {
      gxTv_SdtMotivoEgreso_Megpadre_Z = "" ;
      SetDirty("Megpadre_Z");
   }

   public boolean getgxTv_SdtMotivoEgreso_Megpadre_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtMotivoEgreso_Megrelref_Z( )
   {
      return gxTv_SdtMotivoEgreso_Megrelref_Z ;
   }

   public void setgxTv_SdtMotivoEgreso_Megrelref_Z( String value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      SetDirty("Megrelref_Z");
      gxTv_SdtMotivoEgreso_Megrelref_Z = value ;
   }

   public void setgxTv_SdtMotivoEgreso_Megrelref_Z_SetNull( )
   {
      gxTv_SdtMotivoEgreso_Megrelref_Z = "" ;
      SetDirty("Megrelref_Z");
   }

   public boolean getgxTv_SdtMotivoEgreso_Megrelref_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtMotivoEgreso_Megres551_N( )
   {
      return gxTv_SdtMotivoEgreso_Megres551_N ;
   }

   public void setgxTv_SdtMotivoEgreso_Megres551_N( byte value )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(0) ;
      SetDirty("Megres551_N");
      gxTv_SdtMotivoEgreso_Megres551_N = value ;
   }

   public void setgxTv_SdtMotivoEgreso_Megres551_N_SetNull( )
   {
      gxTv_SdtMotivoEgreso_Megres551_N = (byte)(0) ;
      SetDirty("Megres551_N");
   }

   public boolean getgxTv_SdtMotivoEgreso_Megres551_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.motivoegreso_bc obj;
      obj = new web.motivoegreso_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtMotivoEgreso_N = (byte)(1) ;
      gxTv_SdtMotivoEgreso_Megcodigo = "" ;
      gxTv_SdtMotivoEgreso_Megdescrip = "" ;
      gxTv_SdtMotivoEgreso_Megres551 = "" ;
      gxTv_SdtMotivoEgreso_Megpadre = "" ;
      gxTv_SdtMotivoEgreso_Megrelref = "" ;
      gxTv_SdtMotivoEgreso_Megold = "" ;
      gxTv_SdtMotivoEgreso_Mode = "" ;
      gxTv_SdtMotivoEgreso_Megcodigo_Z = "" ;
      gxTv_SdtMotivoEgreso_Megdescrip_Z = "" ;
      gxTv_SdtMotivoEgreso_Megres551_Z = "" ;
      gxTv_SdtMotivoEgreso_Megpadre_Z = "" ;
      gxTv_SdtMotivoEgreso_Megrelref_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtMotivoEgreso_N ;
   }

   public web.SdtMotivoEgreso Clone( )
   {
      web.SdtMotivoEgreso sdt;
      web.motivoegreso_bc obj;
      sdt = (web.SdtMotivoEgreso)(clone()) ;
      obj = (web.motivoegreso_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtMotivoEgreso struct )
   {
      setgxTv_SdtMotivoEgreso_Clicod(struct.getClicod());
      setgxTv_SdtMotivoEgreso_Megcodigo(struct.getMegcodigo());
      setgxTv_SdtMotivoEgreso_Megdescrip(struct.getMegdescrip());
      setgxTv_SdtMotivoEgreso_Meghabilitado(struct.getMeghabilitado());
      setgxTv_SdtMotivoEgreso_Megres551(struct.getMegres551());
      setgxTv_SdtMotivoEgreso_Megrelsec(struct.getMegrelsec());
      setgxTv_SdtMotivoEgreso_Megrelseccli(struct.getMegrelseccli());
      setgxTv_SdtMotivoEgreso_Megpadre(struct.getMegpadre());
      setgxTv_SdtMotivoEgreso_Megrelref(struct.getMegrelref());
      setgxTv_SdtMotivoEgreso_Megold(struct.getMegold());
      GXBCLevelCollection<web.SdtMotivoEgreso_RevistaAfip> gxTv_SdtMotivoEgreso_Revistaafip_aux = new GXBCLevelCollection<web.SdtMotivoEgreso_RevistaAfip>(web.SdtMotivoEgreso_RevistaAfip.class, "MotivoEgreso.RevistaAfip", "PayDay", remoteHandle);
      Vector<web.StructSdtMotivoEgreso_RevistaAfip> gxTv_SdtMotivoEgreso_Revistaafip_aux1 = struct.getRevistaafip();
      if (gxTv_SdtMotivoEgreso_Revistaafip_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtMotivoEgreso_Revistaafip_aux1.size(); i++)
         {
            gxTv_SdtMotivoEgreso_Revistaafip_aux.add(new web.SdtMotivoEgreso_RevistaAfip(remoteHandle, gxTv_SdtMotivoEgreso_Revistaafip_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtMotivoEgreso_Revistaafip(gxTv_SdtMotivoEgreso_Revistaafip_aux);
      setgxTv_SdtMotivoEgreso_Mode(struct.getMode());
      setgxTv_SdtMotivoEgreso_Initialized(struct.getInitialized());
      setgxTv_SdtMotivoEgreso_Clicod_Z(struct.getClicod_Z());
      setgxTv_SdtMotivoEgreso_Megcodigo_Z(struct.getMegcodigo_Z());
      setgxTv_SdtMotivoEgreso_Megdescrip_Z(struct.getMegdescrip_Z());
      setgxTv_SdtMotivoEgreso_Meghabilitado_Z(struct.getMeghabilitado_Z());
      setgxTv_SdtMotivoEgreso_Megres551_Z(struct.getMegres551_Z());
      setgxTv_SdtMotivoEgreso_Megrelsec_Z(struct.getMegrelsec_Z());
      setgxTv_SdtMotivoEgreso_Megrelseccli_Z(struct.getMegrelseccli_Z());
      setgxTv_SdtMotivoEgreso_Megpadre_Z(struct.getMegpadre_Z());
      setgxTv_SdtMotivoEgreso_Megrelref_Z(struct.getMegrelref_Z());
      setgxTv_SdtMotivoEgreso_Megres551_N(struct.getMegres551_N());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtMotivoEgreso getStruct( )
   {
      web.StructSdtMotivoEgreso struct = new web.StructSdtMotivoEgreso ();
      struct.setClicod(getgxTv_SdtMotivoEgreso_Clicod());
      struct.setMegcodigo(getgxTv_SdtMotivoEgreso_Megcodigo());
      struct.setMegdescrip(getgxTv_SdtMotivoEgreso_Megdescrip());
      struct.setMeghabilitado(getgxTv_SdtMotivoEgreso_Meghabilitado());
      struct.setMegres551(getgxTv_SdtMotivoEgreso_Megres551());
      struct.setMegrelsec(getgxTv_SdtMotivoEgreso_Megrelsec());
      struct.setMegrelseccli(getgxTv_SdtMotivoEgreso_Megrelseccli());
      struct.setMegpadre(getgxTv_SdtMotivoEgreso_Megpadre());
      struct.setMegrelref(getgxTv_SdtMotivoEgreso_Megrelref());
      struct.setMegold(getgxTv_SdtMotivoEgreso_Megold());
      struct.setRevistaafip(getgxTv_SdtMotivoEgreso_Revistaafip().getStruct());
      struct.setMode(getgxTv_SdtMotivoEgreso_Mode());
      struct.setInitialized(getgxTv_SdtMotivoEgreso_Initialized());
      struct.setClicod_Z(getgxTv_SdtMotivoEgreso_Clicod_Z());
      struct.setMegcodigo_Z(getgxTv_SdtMotivoEgreso_Megcodigo_Z());
      struct.setMegdescrip_Z(getgxTv_SdtMotivoEgreso_Megdescrip_Z());
      struct.setMeghabilitado_Z(getgxTv_SdtMotivoEgreso_Meghabilitado_Z());
      struct.setMegres551_Z(getgxTv_SdtMotivoEgreso_Megres551_Z());
      struct.setMegrelsec_Z(getgxTv_SdtMotivoEgreso_Megrelsec_Z());
      struct.setMegrelseccli_Z(getgxTv_SdtMotivoEgreso_Megrelseccli_Z());
      struct.setMegpadre_Z(getgxTv_SdtMotivoEgreso_Megpadre_Z());
      struct.setMegrelref_Z(getgxTv_SdtMotivoEgreso_Megrelref_Z());
      struct.setMegres551_N(getgxTv_SdtMotivoEgreso_Megres551_N());
      return struct ;
   }

   private byte gxTv_SdtMotivoEgreso_N ;
   private byte gxTv_SdtMotivoEgreso_Megres551_N ;
   private short gxTv_SdtMotivoEgreso_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtMotivoEgreso_Clicod ;
   private int gxTv_SdtMotivoEgreso_Megrelsec ;
   private int gxTv_SdtMotivoEgreso_Megrelseccli ;
   private int gxTv_SdtMotivoEgreso_Clicod_Z ;
   private int gxTv_SdtMotivoEgreso_Megrelsec_Z ;
   private int gxTv_SdtMotivoEgreso_Megrelseccli_Z ;
   private String gxTv_SdtMotivoEgreso_Megcodigo ;
   private String gxTv_SdtMotivoEgreso_Megres551 ;
   private String gxTv_SdtMotivoEgreso_Megpadre ;
   private String gxTv_SdtMotivoEgreso_Mode ;
   private String gxTv_SdtMotivoEgreso_Megcodigo_Z ;
   private String gxTv_SdtMotivoEgreso_Megres551_Z ;
   private String gxTv_SdtMotivoEgreso_Megpadre_Z ;
   private String sTagName ;
   private boolean gxTv_SdtMotivoEgreso_Meghabilitado ;
   private boolean gxTv_SdtMotivoEgreso_Meghabilitado_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtMotivoEgreso_Megold ;
   private String gxTv_SdtMotivoEgreso_Megdescrip ;
   private String gxTv_SdtMotivoEgreso_Megrelref ;
   private String gxTv_SdtMotivoEgreso_Megdescrip_Z ;
   private String gxTv_SdtMotivoEgreso_Megrelref_Z ;
   private GXBCLevelCollection<web.SdtMotivoEgreso_RevistaAfip> gxTv_SdtMotivoEgreso_Revistaafip_aux ;
   private GXBCLevelCollection<web.SdtMotivoEgreso_RevistaAfip> gxTv_SdtMotivoEgreso_Revistaafip=null ;
}

