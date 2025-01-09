package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSecUser extends GxSilentTrnSdt
{
   public SdtSecUser( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtSecUser.class));
   }

   public SdtSecUser( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle, context, "SdtSecUser");
      initialize( remoteHandle) ;
   }

   public SdtSecUser( int remoteHandle ,
                      StructSdtSecUser struct )
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

   public void Load( short AV67SecUserId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Short.valueOf(AV67SecUserId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"SecUserId", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "WWPBaseObjects\\SecUser");
      metadata.set("BT", "SecUser");
      metadata.set("PK", "[ \"SecUserId\" ]");
      metadata.set("PKAssigned", "[ \"SecUserId\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"PaiCod\" ],\"FKMap\":[ \"SecUserPaiCod-PaiCod\" ] },{ \"FK\":[ \"PerfilId\" ],\"FKMap\":[  ] },{ \"FK\":[ \"RolId\" ],\"FKMap\":[  ] },{ \"FK\":[ \"RolId\",\"PerfilId\",\"MenuVerId\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserId") )
            {
               gxTv_SdtSecUser_Secuserid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserName") )
            {
               gxTv_SdtSecUser_Secusername = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserPassword") )
            {
               gxTv_SdtSecUser_Secuserpassword = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod") )
            {
               gxTv_SdtSecUser_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserEmpNom") )
            {
               gxTv_SdtSecUser_Secuserempnom = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUsuActivo") )
            {
               gxTv_SdtSecUser_Secusuactivo = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserPerName") )
            {
               gxTv_SdtSecUser_Secuserpername = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserPerLastName") )
            {
               gxTv_SdtSecUser_Secuserperlastname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserEmpCuit") )
            {
               gxTv_SdtSecUser_Secuserempcuit = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserTipEmpl") )
            {
               gxTv_SdtSecUser_Secusertipempl = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserPaiCod") )
            {
               gxTv_SdtSecUser_Secuserpaicod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RolId") )
            {
               gxTv_SdtSecUser_Rolid = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PerfilId") )
            {
               gxTv_SdtSecUser_Perfilid = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuVerId") )
            {
               gxTv_SdtSecUser_Menuverid = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RolNombre") )
            {
               gxTv_SdtSecUser_Rolnombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserSal") )
            {
               gxTv_SdtSecUser_Secusersal = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtSecUser_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtSecUser_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserId_Z") )
            {
               gxTv_SdtSecUser_Secuserid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserName_Z") )
            {
               gxTv_SdtSecUser_Secusername_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserPassword_Z") )
            {
               gxTv_SdtSecUser_Secuserpassword_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_SdtSecUser_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserEmpNom_Z") )
            {
               gxTv_SdtSecUser_Secuserempnom_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUsuActivo_Z") )
            {
               gxTv_SdtSecUser_Secusuactivo_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserPerName_Z") )
            {
               gxTv_SdtSecUser_Secuserpername_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserPerLastName_Z") )
            {
               gxTv_SdtSecUser_Secuserperlastname_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserEmpCuit_Z") )
            {
               gxTv_SdtSecUser_Secuserempcuit_Z = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserTipEmpl_Z") )
            {
               gxTv_SdtSecUser_Secusertipempl_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserPaiCod_Z") )
            {
               gxTv_SdtSecUser_Secuserpaicod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RolId_Z") )
            {
               gxTv_SdtSecUser_Rolid_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PerfilId_Z") )
            {
               gxTv_SdtSecUser_Perfilid_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuVerId_Z") )
            {
               gxTv_SdtSecUser_Menuverid_Z = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RolNombre_Z") )
            {
               gxTv_SdtSecUser_Rolnombre_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserSal_Z") )
            {
               gxTv_SdtSecUser_Secusersal_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_N") )
            {
               gxTv_SdtSecUser_Clicod_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserPaiCod_N") )
            {
               gxTv_SdtSecUser_Secuserpaicod_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "RolId_N") )
            {
               gxTv_SdtSecUser_Rolid_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PerfilId_N") )
            {
               gxTv_SdtSecUser_Perfilid_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuVerId_N") )
            {
               gxTv_SdtSecUser_Menuverid_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "SecUser" ;
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
      oWriter.writeElement("SecUserId", GXutil.trim( GXutil.str( gxTv_SdtSecUser_Secuserid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SecUserName", gxTv_SdtSecUser_Secusername);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SecUserPassword", gxTv_SdtSecUser_Secuserpassword);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_SdtSecUser_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SecUserEmpNom", gxTv_SdtSecUser_Secuserempnom);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SecUsuActivo", GXutil.booltostr( gxTv_SdtSecUser_Secusuactivo));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SecUserPerName", gxTv_SdtSecUser_Secuserpername);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SecUserPerLastName", gxTv_SdtSecUser_Secuserperlastname);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SecUserEmpCuit", GXutil.trim( GXutil.str( gxTv_SdtSecUser_Secuserempcuit, 11, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SecUserTipEmpl", gxTv_SdtSecUser_Secusertipempl);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SecUserPaiCod", GXutil.trim( GXutil.str( gxTv_SdtSecUser_Secuserpaicod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("RolId", GXutil.trim( GXutil.str( gxTv_SdtSecUser_Rolid, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PerfilId", GXutil.trim( GXutil.str( gxTv_SdtSecUser_Perfilid, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MenuVerId", GXutil.trim( GXutil.str( gxTv_SdtSecUser_Menuverid, 15, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("RolNombre", gxTv_SdtSecUser_Rolnombre);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SecUserSal", gxTv_SdtSecUser_Secusersal);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtSecUser_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtSecUser_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SecUserId_Z", GXutil.trim( GXutil.str( gxTv_SdtSecUser_Secuserid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SecUserName_Z", gxTv_SdtSecUser_Secusername_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SecUserPassword_Z", gxTv_SdtSecUser_Secuserpassword_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_SdtSecUser_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SecUserEmpNom_Z", gxTv_SdtSecUser_Secuserempnom_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SecUsuActivo_Z", GXutil.booltostr( gxTv_SdtSecUser_Secusuactivo_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SecUserPerName_Z", gxTv_SdtSecUser_Secuserpername_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SecUserPerLastName_Z", gxTv_SdtSecUser_Secuserperlastname_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SecUserEmpCuit_Z", GXutil.trim( GXutil.str( gxTv_SdtSecUser_Secuserempcuit_Z, 11, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SecUserTipEmpl_Z", gxTv_SdtSecUser_Secusertipempl_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SecUserPaiCod_Z", GXutil.trim( GXutil.str( gxTv_SdtSecUser_Secuserpaicod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("RolId_Z", GXutil.trim( GXutil.str( gxTv_SdtSecUser_Rolid_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PerfilId_Z", GXutil.trim( GXutil.str( gxTv_SdtSecUser_Perfilid_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MenuVerId_Z", GXutil.trim( GXutil.str( gxTv_SdtSecUser_Menuverid_Z, 15, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("RolNombre_Z", gxTv_SdtSecUser_Rolnombre_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SecUserSal_Z", gxTv_SdtSecUser_Secusersal_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_N", GXutil.trim( GXutil.str( gxTv_SdtSecUser_Clicod_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SecUserPaiCod_N", GXutil.trim( GXutil.str( gxTv_SdtSecUser_Secuserpaicod_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("RolId_N", GXutil.trim( GXutil.str( gxTv_SdtSecUser_Rolid_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PerfilId_N", GXutil.trim( GXutil.str( gxTv_SdtSecUser_Perfilid_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MenuVerId_N", GXutil.trim( GXutil.str( gxTv_SdtSecUser_Menuverid_N, 1, 0)));
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
      AddObjectProperty("SecUserId", gxTv_SdtSecUser_Secuserid, false, includeNonInitialized);
      AddObjectProperty("SecUserName", gxTv_SdtSecUser_Secusername, false, includeNonInitialized);
      AddObjectProperty("SecUserPassword", gxTv_SdtSecUser_Secuserpassword, false, includeNonInitialized);
      AddObjectProperty("CliCod", gxTv_SdtSecUser_Clicod, false, includeNonInitialized);
      AddObjectProperty("CliCod_N", gxTv_SdtSecUser_Clicod_N, false, includeNonInitialized);
      AddObjectProperty("SecUserEmpNom", gxTv_SdtSecUser_Secuserempnom, false, includeNonInitialized);
      AddObjectProperty("SecUsuActivo", gxTv_SdtSecUser_Secusuactivo, false, includeNonInitialized);
      AddObjectProperty("SecUserPerName", gxTv_SdtSecUser_Secuserpername, false, includeNonInitialized);
      AddObjectProperty("SecUserPerLastName", gxTv_SdtSecUser_Secuserperlastname, false, includeNonInitialized);
      AddObjectProperty("SecUserEmpCuit", gxTv_SdtSecUser_Secuserempcuit, false, includeNonInitialized);
      AddObjectProperty("SecUserTipEmpl", gxTv_SdtSecUser_Secusertipempl, false, includeNonInitialized);
      AddObjectProperty("SecUserPaiCod", gxTv_SdtSecUser_Secuserpaicod, false, includeNonInitialized);
      AddObjectProperty("SecUserPaiCod_N", gxTv_SdtSecUser_Secuserpaicod_N, false, includeNonInitialized);
      AddObjectProperty("RolId", gxTv_SdtSecUser_Rolid, false, includeNonInitialized);
      AddObjectProperty("RolId_N", gxTv_SdtSecUser_Rolid_N, false, includeNonInitialized);
      AddObjectProperty("PerfilId", gxTv_SdtSecUser_Perfilid, false, includeNonInitialized);
      AddObjectProperty("PerfilId_N", gxTv_SdtSecUser_Perfilid_N, false, includeNonInitialized);
      AddObjectProperty("MenuVerId", gxTv_SdtSecUser_Menuverid, false, includeNonInitialized);
      AddObjectProperty("MenuVerId_N", gxTv_SdtSecUser_Menuverid_N, false, includeNonInitialized);
      AddObjectProperty("RolNombre", gxTv_SdtSecUser_Rolnombre, false, includeNonInitialized);
      AddObjectProperty("SecUserSal", gxTv_SdtSecUser_Secusersal, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtSecUser_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtSecUser_Initialized, false, includeNonInitialized);
         AddObjectProperty("SecUserId_Z", gxTv_SdtSecUser_Secuserid_Z, false, includeNonInitialized);
         AddObjectProperty("SecUserName_Z", gxTv_SdtSecUser_Secusername_Z, false, includeNonInitialized);
         AddObjectProperty("SecUserPassword_Z", gxTv_SdtSecUser_Secuserpassword_Z, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_SdtSecUser_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("SecUserEmpNom_Z", gxTv_SdtSecUser_Secuserempnom_Z, false, includeNonInitialized);
         AddObjectProperty("SecUsuActivo_Z", gxTv_SdtSecUser_Secusuactivo_Z, false, includeNonInitialized);
         AddObjectProperty("SecUserPerName_Z", gxTv_SdtSecUser_Secuserpername_Z, false, includeNonInitialized);
         AddObjectProperty("SecUserPerLastName_Z", gxTv_SdtSecUser_Secuserperlastname_Z, false, includeNonInitialized);
         AddObjectProperty("SecUserEmpCuit_Z", gxTv_SdtSecUser_Secuserempcuit_Z, false, includeNonInitialized);
         AddObjectProperty("SecUserTipEmpl_Z", gxTv_SdtSecUser_Secusertipempl_Z, false, includeNonInitialized);
         AddObjectProperty("SecUserPaiCod_Z", gxTv_SdtSecUser_Secuserpaicod_Z, false, includeNonInitialized);
         AddObjectProperty("RolId_Z", gxTv_SdtSecUser_Rolid_Z, false, includeNonInitialized);
         AddObjectProperty("PerfilId_Z", gxTv_SdtSecUser_Perfilid_Z, false, includeNonInitialized);
         AddObjectProperty("MenuVerId_Z", gxTv_SdtSecUser_Menuverid_Z, false, includeNonInitialized);
         AddObjectProperty("RolNombre_Z", gxTv_SdtSecUser_Rolnombre_Z, false, includeNonInitialized);
         AddObjectProperty("SecUserSal_Z", gxTv_SdtSecUser_Secusersal_Z, false, includeNonInitialized);
         AddObjectProperty("CliCod_N", gxTv_SdtSecUser_Clicod_N, false, includeNonInitialized);
         AddObjectProperty("SecUserPaiCod_N", gxTv_SdtSecUser_Secuserpaicod_N, false, includeNonInitialized);
         AddObjectProperty("RolId_N", gxTv_SdtSecUser_Rolid_N, false, includeNonInitialized);
         AddObjectProperty("PerfilId_N", gxTv_SdtSecUser_Perfilid_N, false, includeNonInitialized);
         AddObjectProperty("MenuVerId_N", gxTv_SdtSecUser_Menuverid_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.wwpbaseobjects.SdtSecUser sdt )
   {
      if ( sdt.IsDirty("SecUserId") )
      {
         gxTv_SdtSecUser_N = (byte)(0) ;
         gxTv_SdtSecUser_Secuserid = sdt.getgxTv_SdtSecUser_Secuserid() ;
      }
      if ( sdt.IsDirty("SecUserName") )
      {
         gxTv_SdtSecUser_N = (byte)(0) ;
         gxTv_SdtSecUser_Secusername = sdt.getgxTv_SdtSecUser_Secusername() ;
      }
      if ( sdt.IsDirty("SecUserPassword") )
      {
         gxTv_SdtSecUser_N = (byte)(0) ;
         gxTv_SdtSecUser_Secuserpassword = sdt.getgxTv_SdtSecUser_Secuserpassword() ;
      }
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_SdtSecUser_Clicod_N = sdt.getgxTv_SdtSecUser_Clicod_N() ;
         gxTv_SdtSecUser_N = (byte)(0) ;
         gxTv_SdtSecUser_Clicod = sdt.getgxTv_SdtSecUser_Clicod() ;
      }
      if ( sdt.IsDirty("SecUserEmpNom") )
      {
         gxTv_SdtSecUser_N = (byte)(0) ;
         gxTv_SdtSecUser_Secuserempnom = sdt.getgxTv_SdtSecUser_Secuserempnom() ;
      }
      if ( sdt.IsDirty("SecUsuActivo") )
      {
         gxTv_SdtSecUser_N = (byte)(0) ;
         gxTv_SdtSecUser_Secusuactivo = sdt.getgxTv_SdtSecUser_Secusuactivo() ;
      }
      if ( sdt.IsDirty("SecUserPerName") )
      {
         gxTv_SdtSecUser_N = (byte)(0) ;
         gxTv_SdtSecUser_Secuserpername = sdt.getgxTv_SdtSecUser_Secuserpername() ;
      }
      if ( sdt.IsDirty("SecUserPerLastName") )
      {
         gxTv_SdtSecUser_N = (byte)(0) ;
         gxTv_SdtSecUser_Secuserperlastname = sdt.getgxTv_SdtSecUser_Secuserperlastname() ;
      }
      if ( sdt.IsDirty("SecUserEmpCuit") )
      {
         gxTv_SdtSecUser_N = (byte)(0) ;
         gxTv_SdtSecUser_Secuserempcuit = sdt.getgxTv_SdtSecUser_Secuserempcuit() ;
      }
      if ( sdt.IsDirty("SecUserTipEmpl") )
      {
         gxTv_SdtSecUser_N = (byte)(0) ;
         gxTv_SdtSecUser_Secusertipempl = sdt.getgxTv_SdtSecUser_Secusertipempl() ;
      }
      if ( sdt.IsDirty("SecUserPaiCod") )
      {
         gxTv_SdtSecUser_Secuserpaicod_N = sdt.getgxTv_SdtSecUser_Secuserpaicod_N() ;
         gxTv_SdtSecUser_N = (byte)(0) ;
         gxTv_SdtSecUser_Secuserpaicod = sdt.getgxTv_SdtSecUser_Secuserpaicod() ;
      }
      if ( sdt.IsDirty("RolId") )
      {
         gxTv_SdtSecUser_Rolid_N = sdt.getgxTv_SdtSecUser_Rolid_N() ;
         gxTv_SdtSecUser_N = (byte)(0) ;
         gxTv_SdtSecUser_Rolid = sdt.getgxTv_SdtSecUser_Rolid() ;
      }
      if ( sdt.IsDirty("PerfilId") )
      {
         gxTv_SdtSecUser_Perfilid_N = sdt.getgxTv_SdtSecUser_Perfilid_N() ;
         gxTv_SdtSecUser_N = (byte)(0) ;
         gxTv_SdtSecUser_Perfilid = sdt.getgxTv_SdtSecUser_Perfilid() ;
      }
      if ( sdt.IsDirty("MenuVerId") )
      {
         gxTv_SdtSecUser_Menuverid_N = sdt.getgxTv_SdtSecUser_Menuverid_N() ;
         gxTv_SdtSecUser_N = (byte)(0) ;
         gxTv_SdtSecUser_Menuverid = sdt.getgxTv_SdtSecUser_Menuverid() ;
      }
      if ( sdt.IsDirty("RolNombre") )
      {
         gxTv_SdtSecUser_N = (byte)(0) ;
         gxTv_SdtSecUser_Rolnombre = sdt.getgxTv_SdtSecUser_Rolnombre() ;
      }
      if ( sdt.IsDirty("SecUserSal") )
      {
         gxTv_SdtSecUser_N = (byte)(0) ;
         gxTv_SdtSecUser_Secusersal = sdt.getgxTv_SdtSecUser_Secusersal() ;
      }
   }

   public short getgxTv_SdtSecUser_Secuserid( )
   {
      return gxTv_SdtSecUser_Secuserid ;
   }

   public void setgxTv_SdtSecUser_Secuserid( short value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      if ( gxTv_SdtSecUser_Secuserid != value )
      {
         gxTv_SdtSecUser_Mode = "INS" ;
         this.setgxTv_SdtSecUser_Secuserid_Z_SetNull( );
         this.setgxTv_SdtSecUser_Secusername_Z_SetNull( );
         this.setgxTv_SdtSecUser_Secuserpassword_Z_SetNull( );
         this.setgxTv_SdtSecUser_Clicod_Z_SetNull( );
         this.setgxTv_SdtSecUser_Secuserempnom_Z_SetNull( );
         this.setgxTv_SdtSecUser_Secusuactivo_Z_SetNull( );
         this.setgxTv_SdtSecUser_Secuserpername_Z_SetNull( );
         this.setgxTv_SdtSecUser_Secuserperlastname_Z_SetNull( );
         this.setgxTv_SdtSecUser_Secuserempcuit_Z_SetNull( );
         this.setgxTv_SdtSecUser_Secusertipempl_Z_SetNull( );
         this.setgxTv_SdtSecUser_Secuserpaicod_Z_SetNull( );
         this.setgxTv_SdtSecUser_Rolid_Z_SetNull( );
         this.setgxTv_SdtSecUser_Perfilid_Z_SetNull( );
         this.setgxTv_SdtSecUser_Menuverid_Z_SetNull( );
         this.setgxTv_SdtSecUser_Rolnombre_Z_SetNull( );
         this.setgxTv_SdtSecUser_Secusersal_Z_SetNull( );
      }
      SetDirty("Secuserid");
      gxTv_SdtSecUser_Secuserid = value ;
   }

   public String getgxTv_SdtSecUser_Secusername( )
   {
      return gxTv_SdtSecUser_Secusername ;
   }

   public void setgxTv_SdtSecUser_Secusername( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Secusername");
      gxTv_SdtSecUser_Secusername = value ;
   }

   public String getgxTv_SdtSecUser_Secuserpassword( )
   {
      return gxTv_SdtSecUser_Secuserpassword ;
   }

   public void setgxTv_SdtSecUser_Secuserpassword( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Secuserpassword");
      gxTv_SdtSecUser_Secuserpassword = value ;
   }

   public int getgxTv_SdtSecUser_Clicod( )
   {
      return gxTv_SdtSecUser_Clicod ;
   }

   public void setgxTv_SdtSecUser_Clicod( int value )
   {
      gxTv_SdtSecUser_Clicod_N = (byte)(0) ;
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Clicod");
      gxTv_SdtSecUser_Clicod = value ;
   }

   public void setgxTv_SdtSecUser_Clicod_SetNull( )
   {
      gxTv_SdtSecUser_Clicod_N = (byte)(1) ;
      gxTv_SdtSecUser_Clicod = 0 ;
      SetDirty("Clicod");
   }

   public boolean getgxTv_SdtSecUser_Clicod_IsNull( )
   {
      return (gxTv_SdtSecUser_Clicod_N==1) ;
   }

   public String getgxTv_SdtSecUser_Secuserempnom( )
   {
      return gxTv_SdtSecUser_Secuserempnom ;
   }

   public void setgxTv_SdtSecUser_Secuserempnom( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Secuserempnom");
      gxTv_SdtSecUser_Secuserempnom = value ;
   }

   public boolean getgxTv_SdtSecUser_Secusuactivo( )
   {
      return gxTv_SdtSecUser_Secusuactivo ;
   }

   public void setgxTv_SdtSecUser_Secusuactivo( boolean value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Secusuactivo");
      gxTv_SdtSecUser_Secusuactivo = value ;
   }

   public String getgxTv_SdtSecUser_Secuserpername( )
   {
      return gxTv_SdtSecUser_Secuserpername ;
   }

   public void setgxTv_SdtSecUser_Secuserpername( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Secuserpername");
      gxTv_SdtSecUser_Secuserpername = value ;
   }

   public String getgxTv_SdtSecUser_Secuserperlastname( )
   {
      return gxTv_SdtSecUser_Secuserperlastname ;
   }

   public void setgxTv_SdtSecUser_Secuserperlastname( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Secuserperlastname");
      gxTv_SdtSecUser_Secuserperlastname = value ;
   }

   public long getgxTv_SdtSecUser_Secuserempcuit( )
   {
      return gxTv_SdtSecUser_Secuserempcuit ;
   }

   public void setgxTv_SdtSecUser_Secuserempcuit( long value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Secuserempcuit");
      gxTv_SdtSecUser_Secuserempcuit = value ;
   }

   public String getgxTv_SdtSecUser_Secusertipempl( )
   {
      return gxTv_SdtSecUser_Secusertipempl ;
   }

   public void setgxTv_SdtSecUser_Secusertipempl( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Secusertipempl");
      gxTv_SdtSecUser_Secusertipempl = value ;
   }

   public short getgxTv_SdtSecUser_Secuserpaicod( )
   {
      return gxTv_SdtSecUser_Secuserpaicod ;
   }

   public void setgxTv_SdtSecUser_Secuserpaicod( short value )
   {
      gxTv_SdtSecUser_Secuserpaicod_N = (byte)(0) ;
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Secuserpaicod");
      gxTv_SdtSecUser_Secuserpaicod = value ;
   }

   public void setgxTv_SdtSecUser_Secuserpaicod_SetNull( )
   {
      gxTv_SdtSecUser_Secuserpaicod_N = (byte)(1) ;
      gxTv_SdtSecUser_Secuserpaicod = (short)(0) ;
      SetDirty("Secuserpaicod");
   }

   public boolean getgxTv_SdtSecUser_Secuserpaicod_IsNull( )
   {
      return (gxTv_SdtSecUser_Secuserpaicod_N==1) ;
   }

   public byte getgxTv_SdtSecUser_Rolid( )
   {
      return gxTv_SdtSecUser_Rolid ;
   }

   public void setgxTv_SdtSecUser_Rolid( byte value )
   {
      gxTv_SdtSecUser_Rolid_N = (byte)(0) ;
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Rolid");
      gxTv_SdtSecUser_Rolid = value ;
   }

   public void setgxTv_SdtSecUser_Rolid_SetNull( )
   {
      gxTv_SdtSecUser_Rolid_N = (byte)(1) ;
      gxTv_SdtSecUser_Rolid = (byte)(0) ;
      SetDirty("Rolid");
   }

   public boolean getgxTv_SdtSecUser_Rolid_IsNull( )
   {
      return (gxTv_SdtSecUser_Rolid_N==1) ;
   }

   public byte getgxTv_SdtSecUser_Perfilid( )
   {
      return gxTv_SdtSecUser_Perfilid ;
   }

   public void setgxTv_SdtSecUser_Perfilid( byte value )
   {
      gxTv_SdtSecUser_Perfilid_N = (byte)(0) ;
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Perfilid");
      gxTv_SdtSecUser_Perfilid = value ;
   }

   public void setgxTv_SdtSecUser_Perfilid_SetNull( )
   {
      gxTv_SdtSecUser_Perfilid_N = (byte)(1) ;
      gxTv_SdtSecUser_Perfilid = (byte)(0) ;
      SetDirty("Perfilid");
   }

   public boolean getgxTv_SdtSecUser_Perfilid_IsNull( )
   {
      return (gxTv_SdtSecUser_Perfilid_N==1) ;
   }

   public long getgxTv_SdtSecUser_Menuverid( )
   {
      return gxTv_SdtSecUser_Menuverid ;
   }

   public void setgxTv_SdtSecUser_Menuverid( long value )
   {
      gxTv_SdtSecUser_Menuverid_N = (byte)(0) ;
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Menuverid");
      gxTv_SdtSecUser_Menuverid = value ;
   }

   public void setgxTv_SdtSecUser_Menuverid_SetNull( )
   {
      gxTv_SdtSecUser_Menuverid_N = (byte)(1) ;
      gxTv_SdtSecUser_Menuverid = 0 ;
      SetDirty("Menuverid");
   }

   public boolean getgxTv_SdtSecUser_Menuverid_IsNull( )
   {
      return (gxTv_SdtSecUser_Menuverid_N==1) ;
   }

   public String getgxTv_SdtSecUser_Rolnombre( )
   {
      return gxTv_SdtSecUser_Rolnombre ;
   }

   public void setgxTv_SdtSecUser_Rolnombre( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Rolnombre");
      gxTv_SdtSecUser_Rolnombre = value ;
   }

   public String getgxTv_SdtSecUser_Secusersal( )
   {
      return gxTv_SdtSecUser_Secusersal ;
   }

   public void setgxTv_SdtSecUser_Secusersal( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Secusersal");
      gxTv_SdtSecUser_Secusersal = value ;
   }

   public String getgxTv_SdtSecUser_Mode( )
   {
      return gxTv_SdtSecUser_Mode ;
   }

   public void setgxTv_SdtSecUser_Mode( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtSecUser_Mode = value ;
   }

   public void setgxTv_SdtSecUser_Mode_SetNull( )
   {
      gxTv_SdtSecUser_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtSecUser_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtSecUser_Initialized( )
   {
      return gxTv_SdtSecUser_Initialized ;
   }

   public void setgxTv_SdtSecUser_Initialized( short value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtSecUser_Initialized = value ;
   }

   public void setgxTv_SdtSecUser_Initialized_SetNull( )
   {
      gxTv_SdtSecUser_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtSecUser_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtSecUser_Secuserid_Z( )
   {
      return gxTv_SdtSecUser_Secuserid_Z ;
   }

   public void setgxTv_SdtSecUser_Secuserid_Z( short value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Secuserid_Z");
      gxTv_SdtSecUser_Secuserid_Z = value ;
   }

   public void setgxTv_SdtSecUser_Secuserid_Z_SetNull( )
   {
      gxTv_SdtSecUser_Secuserid_Z = (short)(0) ;
      SetDirty("Secuserid_Z");
   }

   public boolean getgxTv_SdtSecUser_Secuserid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSecUser_Secusername_Z( )
   {
      return gxTv_SdtSecUser_Secusername_Z ;
   }

   public void setgxTv_SdtSecUser_Secusername_Z( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Secusername_Z");
      gxTv_SdtSecUser_Secusername_Z = value ;
   }

   public void setgxTv_SdtSecUser_Secusername_Z_SetNull( )
   {
      gxTv_SdtSecUser_Secusername_Z = "" ;
      SetDirty("Secusername_Z");
   }

   public boolean getgxTv_SdtSecUser_Secusername_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSecUser_Secuserpassword_Z( )
   {
      return gxTv_SdtSecUser_Secuserpassword_Z ;
   }

   public void setgxTv_SdtSecUser_Secuserpassword_Z( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Secuserpassword_Z");
      gxTv_SdtSecUser_Secuserpassword_Z = value ;
   }

   public void setgxTv_SdtSecUser_Secuserpassword_Z_SetNull( )
   {
      gxTv_SdtSecUser_Secuserpassword_Z = "" ;
      SetDirty("Secuserpassword_Z");
   }

   public boolean getgxTv_SdtSecUser_Secuserpassword_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtSecUser_Clicod_Z( )
   {
      return gxTv_SdtSecUser_Clicod_Z ;
   }

   public void setgxTv_SdtSecUser_Clicod_Z( int value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_SdtSecUser_Clicod_Z = value ;
   }

   public void setgxTv_SdtSecUser_Clicod_Z_SetNull( )
   {
      gxTv_SdtSecUser_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_SdtSecUser_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSecUser_Secuserempnom_Z( )
   {
      return gxTv_SdtSecUser_Secuserempnom_Z ;
   }

   public void setgxTv_SdtSecUser_Secuserempnom_Z( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Secuserempnom_Z");
      gxTv_SdtSecUser_Secuserempnom_Z = value ;
   }

   public void setgxTv_SdtSecUser_Secuserempnom_Z_SetNull( )
   {
      gxTv_SdtSecUser_Secuserempnom_Z = "" ;
      SetDirty("Secuserempnom_Z");
   }

   public boolean getgxTv_SdtSecUser_Secuserempnom_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtSecUser_Secusuactivo_Z( )
   {
      return gxTv_SdtSecUser_Secusuactivo_Z ;
   }

   public void setgxTv_SdtSecUser_Secusuactivo_Z( boolean value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Secusuactivo_Z");
      gxTv_SdtSecUser_Secusuactivo_Z = value ;
   }

   public void setgxTv_SdtSecUser_Secusuactivo_Z_SetNull( )
   {
      gxTv_SdtSecUser_Secusuactivo_Z = false ;
      SetDirty("Secusuactivo_Z");
   }

   public boolean getgxTv_SdtSecUser_Secusuactivo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSecUser_Secuserpername_Z( )
   {
      return gxTv_SdtSecUser_Secuserpername_Z ;
   }

   public void setgxTv_SdtSecUser_Secuserpername_Z( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Secuserpername_Z");
      gxTv_SdtSecUser_Secuserpername_Z = value ;
   }

   public void setgxTv_SdtSecUser_Secuserpername_Z_SetNull( )
   {
      gxTv_SdtSecUser_Secuserpername_Z = "" ;
      SetDirty("Secuserpername_Z");
   }

   public boolean getgxTv_SdtSecUser_Secuserpername_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSecUser_Secuserperlastname_Z( )
   {
      return gxTv_SdtSecUser_Secuserperlastname_Z ;
   }

   public void setgxTv_SdtSecUser_Secuserperlastname_Z( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Secuserperlastname_Z");
      gxTv_SdtSecUser_Secuserperlastname_Z = value ;
   }

   public void setgxTv_SdtSecUser_Secuserperlastname_Z_SetNull( )
   {
      gxTv_SdtSecUser_Secuserperlastname_Z = "" ;
      SetDirty("Secuserperlastname_Z");
   }

   public boolean getgxTv_SdtSecUser_Secuserperlastname_Z_IsNull( )
   {
      return false ;
   }

   public long getgxTv_SdtSecUser_Secuserempcuit_Z( )
   {
      return gxTv_SdtSecUser_Secuserempcuit_Z ;
   }

   public void setgxTv_SdtSecUser_Secuserempcuit_Z( long value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Secuserempcuit_Z");
      gxTv_SdtSecUser_Secuserempcuit_Z = value ;
   }

   public void setgxTv_SdtSecUser_Secuserempcuit_Z_SetNull( )
   {
      gxTv_SdtSecUser_Secuserempcuit_Z = 0 ;
      SetDirty("Secuserempcuit_Z");
   }

   public boolean getgxTv_SdtSecUser_Secuserempcuit_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSecUser_Secusertipempl_Z( )
   {
      return gxTv_SdtSecUser_Secusertipempl_Z ;
   }

   public void setgxTv_SdtSecUser_Secusertipempl_Z( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Secusertipempl_Z");
      gxTv_SdtSecUser_Secusertipempl_Z = value ;
   }

   public void setgxTv_SdtSecUser_Secusertipempl_Z_SetNull( )
   {
      gxTv_SdtSecUser_Secusertipempl_Z = "" ;
      SetDirty("Secusertipempl_Z");
   }

   public boolean getgxTv_SdtSecUser_Secusertipempl_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtSecUser_Secuserpaicod_Z( )
   {
      return gxTv_SdtSecUser_Secuserpaicod_Z ;
   }

   public void setgxTv_SdtSecUser_Secuserpaicod_Z( short value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Secuserpaicod_Z");
      gxTv_SdtSecUser_Secuserpaicod_Z = value ;
   }

   public void setgxTv_SdtSecUser_Secuserpaicod_Z_SetNull( )
   {
      gxTv_SdtSecUser_Secuserpaicod_Z = (short)(0) ;
      SetDirty("Secuserpaicod_Z");
   }

   public boolean getgxTv_SdtSecUser_Secuserpaicod_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtSecUser_Rolid_Z( )
   {
      return gxTv_SdtSecUser_Rolid_Z ;
   }

   public void setgxTv_SdtSecUser_Rolid_Z( byte value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Rolid_Z");
      gxTv_SdtSecUser_Rolid_Z = value ;
   }

   public void setgxTv_SdtSecUser_Rolid_Z_SetNull( )
   {
      gxTv_SdtSecUser_Rolid_Z = (byte)(0) ;
      SetDirty("Rolid_Z");
   }

   public boolean getgxTv_SdtSecUser_Rolid_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtSecUser_Perfilid_Z( )
   {
      return gxTv_SdtSecUser_Perfilid_Z ;
   }

   public void setgxTv_SdtSecUser_Perfilid_Z( byte value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Perfilid_Z");
      gxTv_SdtSecUser_Perfilid_Z = value ;
   }

   public void setgxTv_SdtSecUser_Perfilid_Z_SetNull( )
   {
      gxTv_SdtSecUser_Perfilid_Z = (byte)(0) ;
      SetDirty("Perfilid_Z");
   }

   public boolean getgxTv_SdtSecUser_Perfilid_Z_IsNull( )
   {
      return false ;
   }

   public long getgxTv_SdtSecUser_Menuverid_Z( )
   {
      return gxTv_SdtSecUser_Menuverid_Z ;
   }

   public void setgxTv_SdtSecUser_Menuverid_Z( long value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Menuverid_Z");
      gxTv_SdtSecUser_Menuverid_Z = value ;
   }

   public void setgxTv_SdtSecUser_Menuverid_Z_SetNull( )
   {
      gxTv_SdtSecUser_Menuverid_Z = 0 ;
      SetDirty("Menuverid_Z");
   }

   public boolean getgxTv_SdtSecUser_Menuverid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSecUser_Rolnombre_Z( )
   {
      return gxTv_SdtSecUser_Rolnombre_Z ;
   }

   public void setgxTv_SdtSecUser_Rolnombre_Z( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Rolnombre_Z");
      gxTv_SdtSecUser_Rolnombre_Z = value ;
   }

   public void setgxTv_SdtSecUser_Rolnombre_Z_SetNull( )
   {
      gxTv_SdtSecUser_Rolnombre_Z = "" ;
      SetDirty("Rolnombre_Z");
   }

   public boolean getgxTv_SdtSecUser_Rolnombre_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSecUser_Secusersal_Z( )
   {
      return gxTv_SdtSecUser_Secusersal_Z ;
   }

   public void setgxTv_SdtSecUser_Secusersal_Z( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Secusersal_Z");
      gxTv_SdtSecUser_Secusersal_Z = value ;
   }

   public void setgxTv_SdtSecUser_Secusersal_Z_SetNull( )
   {
      gxTv_SdtSecUser_Secusersal_Z = "" ;
      SetDirty("Secusersal_Z");
   }

   public boolean getgxTv_SdtSecUser_Secusersal_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtSecUser_Clicod_N( )
   {
      return gxTv_SdtSecUser_Clicod_N ;
   }

   public void setgxTv_SdtSecUser_Clicod_N( byte value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Clicod_N");
      gxTv_SdtSecUser_Clicod_N = value ;
   }

   public void setgxTv_SdtSecUser_Clicod_N_SetNull( )
   {
      gxTv_SdtSecUser_Clicod_N = (byte)(0) ;
      SetDirty("Clicod_N");
   }

   public boolean getgxTv_SdtSecUser_Clicod_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtSecUser_Secuserpaicod_N( )
   {
      return gxTv_SdtSecUser_Secuserpaicod_N ;
   }

   public void setgxTv_SdtSecUser_Secuserpaicod_N( byte value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Secuserpaicod_N");
      gxTv_SdtSecUser_Secuserpaicod_N = value ;
   }

   public void setgxTv_SdtSecUser_Secuserpaicod_N_SetNull( )
   {
      gxTv_SdtSecUser_Secuserpaicod_N = (byte)(0) ;
      SetDirty("Secuserpaicod_N");
   }

   public boolean getgxTv_SdtSecUser_Secuserpaicod_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtSecUser_Rolid_N( )
   {
      return gxTv_SdtSecUser_Rolid_N ;
   }

   public void setgxTv_SdtSecUser_Rolid_N( byte value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Rolid_N");
      gxTv_SdtSecUser_Rolid_N = value ;
   }

   public void setgxTv_SdtSecUser_Rolid_N_SetNull( )
   {
      gxTv_SdtSecUser_Rolid_N = (byte)(0) ;
      SetDirty("Rolid_N");
   }

   public boolean getgxTv_SdtSecUser_Rolid_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtSecUser_Perfilid_N( )
   {
      return gxTv_SdtSecUser_Perfilid_N ;
   }

   public void setgxTv_SdtSecUser_Perfilid_N( byte value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Perfilid_N");
      gxTv_SdtSecUser_Perfilid_N = value ;
   }

   public void setgxTv_SdtSecUser_Perfilid_N_SetNull( )
   {
      gxTv_SdtSecUser_Perfilid_N = (byte)(0) ;
      SetDirty("Perfilid_N");
   }

   public boolean getgxTv_SdtSecUser_Perfilid_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtSecUser_Menuverid_N( )
   {
      return gxTv_SdtSecUser_Menuverid_N ;
   }

   public void setgxTv_SdtSecUser_Menuverid_N( byte value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Menuverid_N");
      gxTv_SdtSecUser_Menuverid_N = value ;
   }

   public void setgxTv_SdtSecUser_Menuverid_N_SetNull( )
   {
      gxTv_SdtSecUser_Menuverid_N = (byte)(0) ;
      SetDirty("Menuverid_N");
   }

   public boolean getgxTv_SdtSecUser_Menuverid_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.wwpbaseobjects.secuser_bc obj;
      obj = new web.wwpbaseobjects.secuser_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtSecUser_N = (byte)(1) ;
      gxTv_SdtSecUser_Secusername = "" ;
      gxTv_SdtSecUser_Secuserpassword = "" ;
      gxTv_SdtSecUser_Secuserempnom = "" ;
      gxTv_SdtSecUser_Secuserpername = "" ;
      gxTv_SdtSecUser_Secuserperlastname = "" ;
      gxTv_SdtSecUser_Secusertipempl = "" ;
      gxTv_SdtSecUser_Rolnombre = "" ;
      gxTv_SdtSecUser_Secusersal = "" ;
      gxTv_SdtSecUser_Mode = "" ;
      gxTv_SdtSecUser_Secusername_Z = "" ;
      gxTv_SdtSecUser_Secuserpassword_Z = "" ;
      gxTv_SdtSecUser_Secuserempnom_Z = "" ;
      gxTv_SdtSecUser_Secuserpername_Z = "" ;
      gxTv_SdtSecUser_Secuserperlastname_Z = "" ;
      gxTv_SdtSecUser_Secusertipempl_Z = "" ;
      gxTv_SdtSecUser_Rolnombre_Z = "" ;
      gxTv_SdtSecUser_Secusersal_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSecUser_N ;
   }

   public web.wwpbaseobjects.SdtSecUser Clone( )
   {
      web.wwpbaseobjects.SdtSecUser sdt;
      web.wwpbaseobjects.secuser_bc obj;
      sdt = (web.wwpbaseobjects.SdtSecUser)(clone()) ;
      obj = (web.wwpbaseobjects.secuser_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.wwpbaseobjects.StructSdtSecUser struct )
   {
      setgxTv_SdtSecUser_Secuserid(struct.getSecuserid());
      setgxTv_SdtSecUser_Secusername(struct.getSecusername());
      setgxTv_SdtSecUser_Secuserpassword(struct.getSecuserpassword());
      setgxTv_SdtSecUser_Clicod(struct.getClicod());
      setgxTv_SdtSecUser_Secuserempnom(struct.getSecuserempnom());
      setgxTv_SdtSecUser_Secusuactivo(struct.getSecusuactivo());
      setgxTv_SdtSecUser_Secuserpername(struct.getSecuserpername());
      setgxTv_SdtSecUser_Secuserperlastname(struct.getSecuserperlastname());
      setgxTv_SdtSecUser_Secuserempcuit(struct.getSecuserempcuit());
      setgxTv_SdtSecUser_Secusertipempl(struct.getSecusertipempl());
      setgxTv_SdtSecUser_Secuserpaicod(struct.getSecuserpaicod());
      setgxTv_SdtSecUser_Rolid(struct.getRolid());
      setgxTv_SdtSecUser_Perfilid(struct.getPerfilid());
      setgxTv_SdtSecUser_Menuverid(struct.getMenuverid());
      setgxTv_SdtSecUser_Rolnombre(struct.getRolnombre());
      setgxTv_SdtSecUser_Secusersal(struct.getSecusersal());
      setgxTv_SdtSecUser_Mode(struct.getMode());
      setgxTv_SdtSecUser_Initialized(struct.getInitialized());
      setgxTv_SdtSecUser_Secuserid_Z(struct.getSecuserid_Z());
      setgxTv_SdtSecUser_Secusername_Z(struct.getSecusername_Z());
      setgxTv_SdtSecUser_Secuserpassword_Z(struct.getSecuserpassword_Z());
      setgxTv_SdtSecUser_Clicod_Z(struct.getClicod_Z());
      setgxTv_SdtSecUser_Secuserempnom_Z(struct.getSecuserempnom_Z());
      setgxTv_SdtSecUser_Secusuactivo_Z(struct.getSecusuactivo_Z());
      setgxTv_SdtSecUser_Secuserpername_Z(struct.getSecuserpername_Z());
      setgxTv_SdtSecUser_Secuserperlastname_Z(struct.getSecuserperlastname_Z());
      setgxTv_SdtSecUser_Secuserempcuit_Z(struct.getSecuserempcuit_Z());
      setgxTv_SdtSecUser_Secusertipempl_Z(struct.getSecusertipempl_Z());
      setgxTv_SdtSecUser_Secuserpaicod_Z(struct.getSecuserpaicod_Z());
      setgxTv_SdtSecUser_Rolid_Z(struct.getRolid_Z());
      setgxTv_SdtSecUser_Perfilid_Z(struct.getPerfilid_Z());
      setgxTv_SdtSecUser_Menuverid_Z(struct.getMenuverid_Z());
      setgxTv_SdtSecUser_Rolnombre_Z(struct.getRolnombre_Z());
      setgxTv_SdtSecUser_Secusersal_Z(struct.getSecusersal_Z());
      setgxTv_SdtSecUser_Clicod_N(struct.getClicod_N());
      setgxTv_SdtSecUser_Secuserpaicod_N(struct.getSecuserpaicod_N());
      setgxTv_SdtSecUser_Rolid_N(struct.getRolid_N());
      setgxTv_SdtSecUser_Perfilid_N(struct.getPerfilid_N());
      setgxTv_SdtSecUser_Menuverid_N(struct.getMenuverid_N());
   }

   @SuppressWarnings("unchecked")
   public web.wwpbaseobjects.StructSdtSecUser getStruct( )
   {
      web.wwpbaseobjects.StructSdtSecUser struct = new web.wwpbaseobjects.StructSdtSecUser ();
      struct.setSecuserid(getgxTv_SdtSecUser_Secuserid());
      struct.setSecusername(getgxTv_SdtSecUser_Secusername());
      struct.setSecuserpassword(getgxTv_SdtSecUser_Secuserpassword());
      struct.setClicod(getgxTv_SdtSecUser_Clicod());
      struct.setSecuserempnom(getgxTv_SdtSecUser_Secuserempnom());
      struct.setSecusuactivo(getgxTv_SdtSecUser_Secusuactivo());
      struct.setSecuserpername(getgxTv_SdtSecUser_Secuserpername());
      struct.setSecuserperlastname(getgxTv_SdtSecUser_Secuserperlastname());
      struct.setSecuserempcuit(getgxTv_SdtSecUser_Secuserempcuit());
      struct.setSecusertipempl(getgxTv_SdtSecUser_Secusertipempl());
      struct.setSecuserpaicod(getgxTv_SdtSecUser_Secuserpaicod());
      struct.setRolid(getgxTv_SdtSecUser_Rolid());
      struct.setPerfilid(getgxTv_SdtSecUser_Perfilid());
      struct.setMenuverid(getgxTv_SdtSecUser_Menuverid());
      struct.setRolnombre(getgxTv_SdtSecUser_Rolnombre());
      struct.setSecusersal(getgxTv_SdtSecUser_Secusersal());
      struct.setMode(getgxTv_SdtSecUser_Mode());
      struct.setInitialized(getgxTv_SdtSecUser_Initialized());
      struct.setSecuserid_Z(getgxTv_SdtSecUser_Secuserid_Z());
      struct.setSecusername_Z(getgxTv_SdtSecUser_Secusername_Z());
      struct.setSecuserpassword_Z(getgxTv_SdtSecUser_Secuserpassword_Z());
      struct.setClicod_Z(getgxTv_SdtSecUser_Clicod_Z());
      struct.setSecuserempnom_Z(getgxTv_SdtSecUser_Secuserempnom_Z());
      struct.setSecusuactivo_Z(getgxTv_SdtSecUser_Secusuactivo_Z());
      struct.setSecuserpername_Z(getgxTv_SdtSecUser_Secuserpername_Z());
      struct.setSecuserperlastname_Z(getgxTv_SdtSecUser_Secuserperlastname_Z());
      struct.setSecuserempcuit_Z(getgxTv_SdtSecUser_Secuserempcuit_Z());
      struct.setSecusertipempl_Z(getgxTv_SdtSecUser_Secusertipempl_Z());
      struct.setSecuserpaicod_Z(getgxTv_SdtSecUser_Secuserpaicod_Z());
      struct.setRolid_Z(getgxTv_SdtSecUser_Rolid_Z());
      struct.setPerfilid_Z(getgxTv_SdtSecUser_Perfilid_Z());
      struct.setMenuverid_Z(getgxTv_SdtSecUser_Menuverid_Z());
      struct.setRolnombre_Z(getgxTv_SdtSecUser_Rolnombre_Z());
      struct.setSecusersal_Z(getgxTv_SdtSecUser_Secusersal_Z());
      struct.setClicod_N(getgxTv_SdtSecUser_Clicod_N());
      struct.setSecuserpaicod_N(getgxTv_SdtSecUser_Secuserpaicod_N());
      struct.setRolid_N(getgxTv_SdtSecUser_Rolid_N());
      struct.setPerfilid_N(getgxTv_SdtSecUser_Perfilid_N());
      struct.setMenuverid_N(getgxTv_SdtSecUser_Menuverid_N());
      return struct ;
   }

   private byte gxTv_SdtSecUser_N ;
   private byte gxTv_SdtSecUser_Rolid ;
   private byte gxTv_SdtSecUser_Perfilid ;
   private byte gxTv_SdtSecUser_Rolid_Z ;
   private byte gxTv_SdtSecUser_Perfilid_Z ;
   private byte gxTv_SdtSecUser_Clicod_N ;
   private byte gxTv_SdtSecUser_Secuserpaicod_N ;
   private byte gxTv_SdtSecUser_Rolid_N ;
   private byte gxTv_SdtSecUser_Perfilid_N ;
   private byte gxTv_SdtSecUser_Menuverid_N ;
   private short gxTv_SdtSecUser_Secuserid ;
   private short gxTv_SdtSecUser_Secuserpaicod ;
   private short gxTv_SdtSecUser_Initialized ;
   private short gxTv_SdtSecUser_Secuserid_Z ;
   private short gxTv_SdtSecUser_Secuserpaicod_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtSecUser_Clicod ;
   private int gxTv_SdtSecUser_Clicod_Z ;
   private long gxTv_SdtSecUser_Secuserempcuit ;
   private long gxTv_SdtSecUser_Menuverid ;
   private long gxTv_SdtSecUser_Secuserempcuit_Z ;
   private long gxTv_SdtSecUser_Menuverid_Z ;
   private String gxTv_SdtSecUser_Secusertipempl ;
   private String gxTv_SdtSecUser_Mode ;
   private String gxTv_SdtSecUser_Secusertipempl_Z ;
   private String sTagName ;
   private boolean gxTv_SdtSecUser_Secusuactivo ;
   private boolean gxTv_SdtSecUser_Secusuactivo_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtSecUser_Secusername ;
   private String gxTv_SdtSecUser_Secuserpassword ;
   private String gxTv_SdtSecUser_Secuserempnom ;
   private String gxTv_SdtSecUser_Secuserpername ;
   private String gxTv_SdtSecUser_Secuserperlastname ;
   private String gxTv_SdtSecUser_Rolnombre ;
   private String gxTv_SdtSecUser_Secusersal ;
   private String gxTv_SdtSecUser_Secusername_Z ;
   private String gxTv_SdtSecUser_Secuserpassword_Z ;
   private String gxTv_SdtSecUser_Secuserempnom_Z ;
   private String gxTv_SdtSecUser_Secuserpername_Z ;
   private String gxTv_SdtSecUser_Secuserperlastname_Z ;
   private String gxTv_SdtSecUser_Rolnombre_Z ;
   private String gxTv_SdtSecUser_Secusersal_Z ;
}

