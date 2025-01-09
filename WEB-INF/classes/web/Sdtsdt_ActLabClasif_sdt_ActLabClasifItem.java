package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_ActLabClasif_sdt_ActLabClasifItem extends GxUserType
{
   public Sdtsdt_ActLabClasif_sdt_ActLabClasifItem( )
   {
      this(  new ModelContext(Sdtsdt_ActLabClasif_sdt_ActLabClasifItem.class));
   }

   public Sdtsdt_ActLabClasif_sdt_ActLabClasifItem( ModelContext context )
   {
      super( context, "Sdtsdt_ActLabClasif_sdt_ActLabClasifItem");
   }

   public Sdtsdt_ActLabClasif_sdt_ActLabClasifItem( int remoteHandle ,
                                                    ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_ActLabClasif_sdt_ActLabClasifItem");
   }

   public Sdtsdt_ActLabClasif_sdt_ActLabClasifItem( StructSdtsdt_ActLabClasif_sdt_ActLabClasifItem struct )
   {
      this();
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ActLabNro") )
            {
               gxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabnro = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ActLabDescrip") )
            {
               gxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabdescrip = oReader.getValue() ;
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
         sName = "sdt_ActLabClasif.sdt_ActLabClasifItem" ;
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
      oWriter.writeElement("ActLabNro", GXutil.trim( GXutil.str( gxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabnro, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ActLabDescrip", gxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabdescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
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
      AddObjectProperty("ActLabNro", gxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabnro, false, false);
      AddObjectProperty("ActLabDescrip", gxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabdescrip, false, false);
   }

   public int getgxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabnro( )
   {
      return gxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabnro ;
   }

   public void setgxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabnro( int value )
   {
      gxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_N = (byte)(0) ;
      gxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabnro = value ;
   }

   public String getgxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabdescrip( )
   {
      return gxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabdescrip ;
   }

   public void setgxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabdescrip( String value )
   {
      gxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_N = (byte)(0) ;
      gxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabdescrip = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_N = (byte)(1) ;
      gxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabdescrip = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_N ;
   }

   public web.Sdtsdt_ActLabClasif_sdt_ActLabClasifItem Clone( )
   {
      return (web.Sdtsdt_ActLabClasif_sdt_ActLabClasifItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_ActLabClasif_sdt_ActLabClasifItem struct )
   {
      setgxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabnro(struct.getActlabnro());
      setgxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabdescrip(struct.getActlabdescrip());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_ActLabClasif_sdt_ActLabClasifItem getStruct( )
   {
      web.StructSdtsdt_ActLabClasif_sdt_ActLabClasifItem struct = new web.StructSdtsdt_ActLabClasif_sdt_ActLabClasifItem ();
      struct.setActlabnro(getgxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabnro());
      struct.setActlabdescrip(getgxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabdescrip());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabnro ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_ActLabClasif_sdt_ActLabClasifItem_Actlabdescrip ;
}

